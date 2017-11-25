package io.github.jerukan.util

class Utils {

    companion object Constants {
        val km_multiplier: Float = 1000000f   //how much the kilometers are divided by
        val planet_size_multipler: Float = 1000f  //make planets more visible(?)
        val sun_radius: Float = 695700f
        val sun_draw_radius: Float = sun_radius / km_multiplier
        val t_step: Double = 0.01
    }
}