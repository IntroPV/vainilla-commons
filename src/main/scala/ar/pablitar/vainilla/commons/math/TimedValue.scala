package ar.pablitar.vainilla.commons.math

abstract class ProgressiveValue(initialValue: Double = 0.0, finalValue: Double = 1.0,
    interpolatorKind: InterpolatorKind = InterpolatorKind.Linear) {

  val interpolator = new Interpolator(initialValue, finalValue, interpolatorKind)
  val self = this

  def currentValue = interpolator.interpolate(progress)

  def progress: Double
  
  def *(value: Double) = new ProgressiveValue(initialValue * value, finalValue * value, interpolatorKind) {
    def progress = self.progress
  }
}

class TimedValue(duration: Double,interpolatorKind: InterpolatorKind = InterpolatorKind.Linear, initialValue: Double = 0.0, finalValue: Double = 1.0) extends ProgressiveValue(initialValue, finalValue,
  interpolatorKind) {

  var elapsed = 0.0

  def update(delta: Double) = {
    elapsed += delta
  }

  def progress = {
    elapsed / duration
  }
  
  def isOverDuration = elapsed > duration
}