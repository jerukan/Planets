package io.github.jerukan.planetdata

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import io.github.jerukan.Renderer
import io.github.jerukan.util.Position
import io.github.jerukan.util.Utils

class Planet(planetname: String) {
    var parser: Parser = Parser()
    var info: JsonObject = parser.parse("planets.json") as JsonObject
    var planetinfo: JsonObject = info[planetname] as JsonObject

    val name: String = planetinfo["name"] as String
    val radius: Double = planetinfo["radius"] as Double
    val radius_drawn: Double = radius / Utils.planet_size_multipler
    val apoapsis: Double = planetinfo["apoapsis"] as Double
    val periapsis: Double = planetinfo["periapsis"] as Double
    val semimajor_axis: Double = planetinfo["semimajor_axis"] as Double
    val semimajor_axis_drawn: Double = semimajor_axis / Utils.km_multiplier
    val eccentricity: Double = planetinfo["eccentricity"] as Double
    val avg_orbital_speed: Double = planetinfo["avg_orbital_speed"] as Double

    val semiminor_axis: Double = semimajor_axis * Math.sqrt(1 - eccentricity * eccentricity)
    val semiminor_axis_drawn: Double = semiminor_axis / Utils.km_multiplier
    val orbit: Orbit = Orbit(semimajor_axis, semiminor_axis, apoapsis, periapsis)
    val screen_pos: Position = Position((semimajor_axis_drawn * Math.cos(0.0) + orbit.offsetx + Renderer.originx -
            semimajor_axis_drawn / 2).toFloat(), (semiminor_axis_drawn * Math.sin(0.0) + Renderer.originy - semiminor_axis_drawn / 2).toFloat())

    fun updatePos(time: Double) {
        screen_pos.setPos((semimajor_axis_drawn * Math.cos(time) + orbit.offsetx + Renderer.originx).toFloat(), (semiminor_axis_drawn * Math.sin(time) + Renderer.originy).toFloat())
    }
}