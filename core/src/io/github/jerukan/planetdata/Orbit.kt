package io.github.jerukan.planetdata

import com.badlogic.gdx.math.Ellipse
import io.github.jerukan.Renderer

class Orbit(var semimajor_axis: Double, var semiminor_axis: Double, var apoapsis: Double, var periapsis: Double) {

    var offsetx: Double = (apoapsis - semimajor_axis) / 100000

    var ellipse: Ellipse = Ellipse((Renderer.originx + offsetx).toFloat() - semimajor_axis.toFloat() / 100000 / 2, Renderer.originy - semiminor_axis.toFloat() / 100000 / 2, semimajor_axis.toFloat() / 100000, semiminor_axis.toFloat() / 100000)
}