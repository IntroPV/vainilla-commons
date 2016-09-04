package ar.pablitar.vainilla.appearances

import com.uqbar.vainilla.appearances.Appearance
import com.uqbar.vainilla.GameComponent
import java.awt.Graphics2D
import com.uqbar.vainilla.appearances.Animation

case class TimedAppearance(wrappedAppearance: Appearance, duration: Double)(onFinish: => Any) extends Appearance {
  var elapsed = 0.0
  
  def copy[T](): T = {
    new TimedAppearance(wrappedAppearance.copy(), duration)(onFinish).asInstanceOf[T]
  }

  def getHeight(): Double = {
    wrappedAppearance.getHeight
  }

  def getWidth(): Double = {
    wrappedAppearance.getWidth
  }

  def render(c: GameComponent[_], g: Graphics2D): Unit = {
    wrappedAppearance.render(c, g)
  }

  def update(delta: Double): Unit = {
      elapsed += delta
      if(elapsed > duration) {
        onFinish
        elapsed = 0
      } else {
        wrappedAppearance.update(delta)
      }
  }
}

object TimedAppearance {
  def fromAnimationTo(component: GameComponent[_], anim: Animation, to: Appearance) = {
    TimedAppearance(anim, anim.getDuration) {
      component.setAppearance(to)
    }
  }
}