package ar.pablitar.vainilla.commons.math

/**
 * @author pablitar
 */
object PhysicsUtils {
  def rebound(v: Vector2D, n: Vector2D, dampening: Double = 0.0) = ((-2 + dampening) * v.proyectTo(n)) + v
}