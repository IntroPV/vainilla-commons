package ar.pablitar.vainilla.commons.components

import java.awt.Color
import com.uqbar.vainilla.DeltaState
import com.uqbar.vainilla.GameComponent
import com.uqbar.vainilla.GameScene
import com.uqbar.vainilla.appearances.Circle
import ar.pablitar.vainilla.commons.math.Vector2D
import com.uqbar.vainilla.appearances.Appearance

class Cursor(val appearance:Appearance = new Circle(Color.WHITE, 20))  extends GameComponent[GameScene] {
  
  this.setAppearance(appearance)
  this.setZ(10)
  
  override def update(state: DeltaState) = {
    val mousePos = state.getCurrentMousePosition
    this.setX(state.getCurrentMousePosition.getX)
    this.setY(state.getCurrentMousePosition.getY)
  }

  def center = {
    Vector2D(this.getX.toInt + this.getAppearance.getWidth / 2, this.getY.toInt + this.getAppearance.getHeight / 2)
  }
}