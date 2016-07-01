package ar.pablitar.vainilla.appearances.worldspace

import ar.pablitar.vainilla.appearances.WorldSpaceAppearance

trait ReseteableAppearance extends WorldSpaceAppearance {
  def reset() = {}
}