package ar.pablitar.vainilla.commons.components

import com.uqbar.vainilla.GameScene
import com.uqbar.vainilla.GameComponent
import ar.pablitar.vainilla.commons.math.Vector2D
import ar.pablitar.vainilla.commons.math.Bounds
import ar.pablitar.vainilla.commons.math.InfiniteBounds
import ar.pablitar.vainilla.commons.math.Orientation

/**
 * @author pablitar
 */
class RichGameComponent[T <: GameScene] extends GameComponent[T] with Positionable {
  def width: Double = this.getAppearance.getWidth
  def height: Double = this.getAppearance.getHeight

  def movementBounds: Bounds = InfiniteBounds

  def position_=(v: Vector2D) = {
    val limited = movementBounds.limit(v, (width, height))
    this.setX(limited.x1)
    this.setY(limited.x2)
  }

  def position = Vector2D(getX, getY)

  def center:Vector2D = this.position + (this.width / 2, this.height / 2)
  
  def center(orientation: Orientation):Vector2D = {
    this.center + (orientation.versor * (this.width / 2, this.height / 2))
  }
  
  def centerRight = this.center + (this.width / 2, 0.0)

  def topLeft(position:Vector2D = this.position) = position
  def bottomLeft(position:Vector2D = this.position) = position + (0.0, this.height)
  def bottomRight(position:Vector2D = this.position) = position + (this.width, this.height)
  def topRight(position:Vector2D = this.position) = position + (this.width, 0.0)
}