package io.github.jerukan.planetdata

import com.badlogic.gdx.math.Ellipse
import io.github.jerukan.Renderer
import io.github.jerukan.util.Utils

class Orbit(var semimajor_axis: Double, var semiminor_axis: Double, var apoapsis: Double, var periapsis: Double) {

    var offsetx: Double = (apoapsis - semimajor_axis) / Utils.km_multiplier

    var ellipse: Ellipse = Ellipse((Renderer.originx + offsetx).toFloat() - semimajor_axis.toFloat() / Utils.km_multiplier / 2,
            Renderer.originy - semiminor_axis.toFloat() / Utils.km_multiplier / 2, semimajor_axis.toFloat() / Utils.km_multiplier,
            semiminor_axis.toFloat() / Utils.km_multiplier)
}