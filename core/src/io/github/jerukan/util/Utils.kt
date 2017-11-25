package io.github.jerukan.util

class Utils {

    companion object Constants {
        //i know it's not to scale i don't care
        val km_multiplier: Float = 2000000f   //how much the kilometers are divided by
        val planet_size_multipler: Float = 2000f  //make planets more visible(?)
        val sun_radius: Float = 695700f
        val sun_draw_radius: Float = sun_radius / km_multiplier * 50 //to make sun not a tiny dot
        val t_step: Double = 0.0003
    }
}