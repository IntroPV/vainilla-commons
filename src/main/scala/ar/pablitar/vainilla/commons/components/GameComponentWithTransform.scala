package ar.pablitar.vainilla.commons.components

import com.uqbar.vainilla.GameScene
import com.uqbar.vainilla.GameComponent
import java.awt.geom.AffineTransform
import javax.xml.crypto.dsig.Transform
import ar.pablitar.vainilla.commons.math.Vector2D
import java.awt.Graphics2D
import ar.pablitar.vainilla.appearances.WorldSpaceAppearance

class GameComponentWithTransform[T <: GameScene](var transform:AffineTransform = new AffineTransform()) extends GameComponent[T] with Positionable {
  
  def position: Vector2D = {
    Vector2D(transform.getTranslateX, transform.getTranslateY)
  }

  def position_=(p: Vector2D): Unit = {
    transform.setToTranslation(transform.getTranslateX, transform.getTranslateY)
  }
}