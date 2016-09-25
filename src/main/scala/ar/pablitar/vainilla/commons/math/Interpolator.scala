package ar.pablitar.vainilla.commons.math

trait InterpolatorKind {
  def interpolateNormalized(t: Double): Double = {
    this.doInterpolate(t.max(0).min(1))
  }
  
  def doInterpolate(t: Double) : Double
}

object InterpolatorKind {
  object Linear extends InterpolatorKind {
    def doInterpolate(t: Double) = t
  }
  
  object EaseOutQuad extends InterpolatorKind {
    def doInterpolate(t: Double) = - t * t + t * 2   
  }
}

object Interpolator {
  def linear(minValue: Double, maxValue: Double) = new Interpolator(minValue, maxValue)
}

class Interpolator(val minValue: Double = 0.0, val maxValue: Double = 1.0, kind: InterpolatorKind = InterpolatorKind.Linear) {
  /**
   * @param t entre 0 y 1
   */
  def interpolate(t: Double) = {
    minValue + kind.interpolateNormalized(t) * (maxValue - minValue)
  }
}

