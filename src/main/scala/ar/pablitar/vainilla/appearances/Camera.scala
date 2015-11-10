package ar.pablitar.vainilla.appearances

import ar.pablitar.vainilla.commons.components.Positionable
import ar.pablitar.vainilla.commons.math.Vector2D
import java.awt.geom.AffineTransform

class Camera extends Positionable {
  var transform = new AffineTransform()


  def position: Vector2D = {
    Vector2D(transform.getTranslateX(), transform.getTranslateY)
  }

  def position_=(p: Vector2D): Unit = {
    transform.setToTranslation(p.x1, p.x2)
  }

  def rotate(radians: Double) = {
    transform.rotate(radians, 400, 300)
  }
  
}