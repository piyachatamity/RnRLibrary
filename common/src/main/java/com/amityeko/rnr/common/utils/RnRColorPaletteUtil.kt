package com.amityeko.rnr.common.utils

import androidx.core.graphics.ColorUtils
import com.amityeko.rnr.common.R

object RnRColorPaletteUtil {
    private val lumens = listOf(0, -10, -25, 20, 30, 40, 45, 47)
    var colorPrimary = listOf<Int>()
    var colorSuccess = listOf<Int>()
    var colorError = listOf<Int>()
    var colorCaution = listOf<Int>()
    var colorInfo = listOf<Int>()


    init {
        colorPrimary = calculateColors(R.color.rnr_color_primary)
        colorSuccess = calculateColors(R.color.rnr_color_success)
        colorError = calculateColors(R.color.rnr_color_error)
        colorCaution = calculateColors(R.color.rnr_color_caution)
        colorInfo = calculateColors(R.color.rnr_color_info)
    }

    private fun calculateColors(color: Int): MutableList<Int> {
        val colors = mutableListOf<Int>()
        for (lumen in lumens) {
            val hslColor = FloatArray(3)
            ColorUtils.colorToHSL(color, hslColor)
            hslColor[2] = hslColor[2] + lumen

            val calculatedColor = ColorUtils.HSLToColor(hslColor)
            colors.add(calculatedColor)
        }
        return colors

    }

}