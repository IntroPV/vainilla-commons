package ar.pablitar.vainilla.commons.pooling

import scala.collection.mutable.ArrayBuffer


class ObjectPool[T](newInstance: () => T, reset: (T) => Unit, val initialPoolSize:Int = 512, val maxPoolSize:Int = 1024) {
  
  val pool = new ArrayBuffer[T](initialPoolSize)
  var spawnCount = 0
  var despawnCount = 0
  
  def spawn() :T = {
    spawnCount+=1
    if(!pool.isEmpty) {
      val obj = pool.remove(0)
      reset(obj)
      obj
    } else {
      newInstance()
    }
  }
  
  def despawn(obj:T): Unit = {
    despawnCount+=1
    if(!(pool.size == maxPoolSize)) {
      pool += obj
    }
  }
  
  def activeObjects = spawnCount - despawnCount
}