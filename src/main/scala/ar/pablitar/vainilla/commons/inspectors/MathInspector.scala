package ar.pablitar.vainilla.commons.inspectors

import java.awt.Graphics2D
import ar.pablitar.vainilla.commons.math.Vector2D
import java.awt.geom.AffineTransform
import ar.pablitar.vainilla.commons.math.Semiplane
import java.awt.Color

object MathInspector {

  def renderVector(graphics: Graphics2D, origin: Vector2D, destination: Vector2D) = {
    graphics.setColor(Color.WHITE)
    graphics.drawLine(origin.x1.toInt, origin.x2.toInt, destination.x1.toInt, destination.x2.toInt)
    val beforeTransform = graphics.getTransform()
    val newTransform = AffineTransform.getTranslateInstance(destination.x1, destination.x2)
    newTransform.rotate((destination - origin).angle + Math.PI * 3 / 4)
    graphics.setTransform(newTransform)
    graphics.drawLine(0, 0, 10, 0)
    newTransform.rotate(Math.PI / 2)
    graphics.setTransform(newTransform)
    graphics.drawLine(0, 0, 10, 0)
    graphics.setTransform(beforeTransform)
  }

  def renderSemiplane(graphics: Graphics2D, s: Semiplane) = {
    renderVector(graphics, s.puntoInterno, (s.normal.versor * 40 + s.puntoInterno))
    renderLine(graphics, s.puntoInterno, s.normal.rotate(Math.PI / 2))
  }

  def renderLine(graphics: Graphics2D, point: Vector2D, direction: Vector2D) = {
    graphics.setColor(Color.YELLOW)
    val from = point - direction.versor * 100
    val to = point + direction.versor * 100
    graphics.drawLine(from.x1.toInt, from.x2.toInt, to.x1.toInt, to.x2.toInt)
  }
}