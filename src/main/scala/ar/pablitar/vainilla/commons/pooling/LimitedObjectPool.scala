package ar.pablitar.vainilla.commons.pooling

import scala.collection.mutable.ArrayBuffer

class LimitedObjectPool[T](newInstance: () => T, reset: (T) => Unit, val poolSize:Int = 1024) {

  val pool = new ArrayBuffer[T](poolSize)
  var index = 0
  
  (1 to poolSize).foreach { x =>
    pool += newInstance()
  }

  def spawn(): T = {
    val obj = pool(index % pool.size)
    reset(obj)
    index +=1
    obj
  }

  def despawn(obj: T): Unit = {
  }

}