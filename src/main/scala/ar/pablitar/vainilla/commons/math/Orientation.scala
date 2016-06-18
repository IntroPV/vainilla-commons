package ar.pablitar.vainilla.commons.math

import Vector2D._

abstract class Orientation(val versor: Vector2D)

object Orientation {
  case object EAST extends Orientation((-1, 0))
  case object WEST extends Orientation((1, 0))
  case object NORTH extends Orientation((0, -1))
  case object SOUTH extends Orientation((0, 1))
}
