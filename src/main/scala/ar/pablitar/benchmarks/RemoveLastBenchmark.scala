package ar.pablitar.benchmarks

import scala.collection.mutable.ArrayBuffer

object RemoveLastBenchmark extends Benchmark {

  def elements = 10000

  val array = ArrayBuffer((1 to elements): _*)
  
  def resetArray = {
    array += 1
    array
  }

  def operations = Seq(
    ("Remove from First",
      () => resetArray.remove(array.size - 1)),
    ("Remove from Last",
      () => resetArray.remove(0)))
}