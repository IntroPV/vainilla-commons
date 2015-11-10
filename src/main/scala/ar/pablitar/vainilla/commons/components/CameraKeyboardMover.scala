package ar.pablitar.vainilla.commons.components

import com.uqbar.vainilla.GameComponent
import com.uqbar.vainilla.GameScene
import ar.pablitar.vainilla.appearances.Camera
import com.uqbar.vainilla.DeltaState
import com.uqbar.vainilla.events.constants.Key

class CameraKeyboardMover(camera: Camera) extends GameComponent[GameScene]{
  
  override def update(state: DeltaState) = {
    val delta = 300 * state.getDelta
    if(state.isKeyBeingHold(Key.LEFT)) {
      camera.transform.translate(-delta,0.0)
    }
    
    if(state.isKeyBeingHold(Key.RIGHT)) {
      camera.transform.translate(delta,0.0)
    }
    
    if(state.isKeyBeingHold(Key.UP)) {
      camera.transform.translate(0.0,-delta)
    }
    
    if(state.isKeyBeingHold(Key.DOWN)) {
      camera.transform.translate(0.0,delta)
    }
    
    if(state.isKeyBeingHold(Key.Q)) {
      camera.rotate(-state.getDelta * Math.PI)
    }
    
    if(state.isKeyBeingHold(Key.E)) {
      camera.rotate(state.getDelta * Math.PI)
    } 
  }
}