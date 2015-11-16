package ar.pablitar.vainilla.commons.pooling

import scala.collection.mutable.ArrayBuffer


class ObjectPool[T](newInstance: () => T, reset: (T) => Unit, val initialPoolSize:Int = 512) {
  
  val pool = new ArrayBuffer[T](initialPoolSize)
  
  def spawn() :T = {
    if(!pool.isEmpty) {
      val obj = pool.remove(0)
      reset(obj)
      obj
    } else {
      newInstance()
    }
  }
  
  def despawn(obj:T): Unit = {
    pool += obj
  }
}