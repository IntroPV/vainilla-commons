package ar.pablitar.vainilla.appearances

import com.uqbar.vainilla.GameComponent
import java.awt.Graphics2D
import com.uqbar.vainilla.appearances.Appearance
import ar.pablitar.vainilla.commons.components.GameComponentExtensions._
import com.uqbar.vainilla.DeltaState
import java.awt.geom.AffineTransform
import ar.pablitar.vainilla.commons.math.Vector2D

trait WorldSpaceAppearance extends Appearance {
  def camera: Camera
  def render(component: GameComponent[_], graphics: Graphics2D): Unit = {
    val localTransform = getTransformFor(component)
    this.doRenderAt(localTransform, graphics)
  }

  def render(position: Vector2D, graphics: Graphics2D): Unit = {
    this.doRenderAt(AffineTransform.getTranslateInstance(position.x1, position.x2), graphics)
  }

  var offset: Vector2D = (0, 0)

  //pattern matching para obtener el transform del component

  def height: Double
  def width: Double
  def getHeight = height
  def getWidth = width

  def update(delta: Double): Unit = {}

  def doRenderAt(transform: AffineTransform, graphics: Graphics2D): Unit = {
    val screenTransform = camera.transform.clone().asInstanceOf[AffineTransform]
    screenTransform.concatenate(transform)
    val beforeTransform = graphics.getTransform()
    graphics.transform(screenTransform)
    doRenderAt(offset.x1, offset.x2, graphics)
    graphics.setTransform(beforeTransform)
  }

  def centerBottom = offset = (-width / 2, -height)
  def center= offset = (-width / 2, -height / 2)

  def addOffset(v: Vector2D) = offset += v 

  def doRenderAt(x: Double, y: Double, graphics: Graphics2D): Unit

  def copy[T <: Appearance](): T = { this.doCopy.asInstanceOf[T] }

  def doCopy: Appearance

  def getTransformFor(component: GameComponent[_]): AffineTransform = {
    component match {
      case _ => AffineTransform.getTranslateInstance(component.getX, component.getY)
    }
  }
}