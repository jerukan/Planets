package io.github.jerukan

import io.github.jerukan.planetdata.Planets
import io.github.jerukan.util.Position

class SolarSystem {

    object SolarSystem {
        var sunpos: Position = Position(Renderer.originx, Renderer.originy)

        fun updatePositions(time: Double) {
            for(planet in Planets.planetlist) {
                planet.updatePos(time)
            }
        }
    }
}