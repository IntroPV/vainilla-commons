package ar.pablitar.vainilla.appearances

import com.uqbar.vainilla.appearances.Sprite
import ar.pablitar.vainilla.appearances.worldspace.WorldSpaceSimpleAppearance
import scala.collection.mutable.Map

case class TileSet(sp: Sprite, tileHSize: Int, tileVSize: Int, tileMargin: Int = 0) {

  val loadedTiles = Map.empty[(Int, Int), WorldSpaceAppearance]

  def getTile(i: Int, j: Int)(implicit camera: Camera) = {
    loadedTiles.getOrElseUpdate((i, j),
      WorldSpaceSimpleAppearance(sp.crop(pixelBySize(i, tileHSize), pixelBySize(j, tileVSize), tileHSize, tileVSize)))
  }

  def pixelBySize(coordinate: Int, tileSize: Int) = {
    tileMargin * (coordinate + 1) + tileSize * coordinate + 1
  }

  def toPartialFunction(implicit camera: Camera): PartialFunction[(Int, Int), WorldSpaceAppearance] = {
    { case (i: Int, j: Int) => getTile(i, j) }
  }
}

object TileSet {

  def fromFile(file: String, tileHSize: Int, tileVSize: Int, tileMargin: Int = 0) = {
    new TileSet(Sprite.fromImage(file), tileHSize, tileVSize, tileMargin)
  }
}