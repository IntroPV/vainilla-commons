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

  def center(position: Vector2D = this.position):Vector2D = (this.position - this.appearanceCenter) + (this.width / 2, this.height / 2)
  
  def orientedCenter(orientation: Orientation, position: Vector2D = this.position): Vector2D = {
    this.center(position) + (orientation.versor * (this.width / 2, this.height / 2))
  }
  
  def appearanceCenter:Vector2D = (0,0)

  def topLeft(position:Vector2D = this.position) = position - this.appearanceCenter
  def bottomLeft(position:Vector2D = this.position) = topLeft(position) + (0.0, this.height)
  def bottomRight(position:Vector2D = this.position) = topLeft(position) + (this.width, this.height)
  def topRight(position:Vector2D = this.position) = topLeft(position) + (this.width, 0.0)
}