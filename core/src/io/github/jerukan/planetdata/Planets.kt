package io.github.jerukan.planetdata

class Planets {
    companion object {
        var mercury: Planet = Planet("mercury")
        var venus: Planet = Planet("venus")
        var earth: Planet = Planet("earth")
        var mars: Planet = Planet("mars")
        var jupiter: Planet = Planet("jupiter")
        var saturn: Planet = Planet("saturn")
        var uranus: Planet = Planet("uranus")
        var neptune: Planet = Planet("neptune")
        var pluto: Planet = Planet("pluto")

        var planetlist: Array<Planet> = arrayOf(mercury, venus, earth, mars, jupiter, saturn, uranus, neptune, pluto)
    }
}