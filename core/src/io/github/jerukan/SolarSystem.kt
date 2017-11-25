package io.github.jerukan

import io.github.jerukan.planetdata.Planets
import io.github.jerukan.util.Position
import io.github.jerukan.util.Utils

class SolarSystem {

    object SolarSystem {
        var sunpos: Position = Position(Renderer.originx + Utils.sun_draw_radius, Renderer.originy + Utils.sun_draw_radius)

        fun updatePositions(time: Double) {
            for(planet in Planets.planetlist) {
                planet.updatePos(time)
            }
        }
    }
}