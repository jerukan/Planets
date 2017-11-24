package io.github.jerukan.planetdata

import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser

class Planet(var planetname: String) {
    var parser: Parser = Parser()
    var info: JsonObject = parser.parse("planets.json") as JsonObject
    var planetinfo: JsonObject = info[planetname] as JsonObject

    var name: String = planetinfo["name"] as String
    var apoapsis: Double = planetinfo["apoapsis"] as Double
    var periapsis: Double = planetinfo["periapsis"] as Double
    var semimajor_axis: Double = planetinfo["semimajor_axis"] as Double
    var eccentricity: Double = planetinfo["eccentricity"] as Double
    var avg_orbital_speed: Double = planetinfo["avg_orbital_speed"] as Double

    var semiminor_axis: Double = semimajor_axis * Math.sqrt(1 - eccentricity * eccentricity)
    var orbit: Orbit = Orbit(semimajor_axis, semiminor_axis, apoapsis, periapsis)
}