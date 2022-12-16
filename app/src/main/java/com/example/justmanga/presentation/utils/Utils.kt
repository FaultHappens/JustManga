package com.example.justmanga.presentation.utils

import android.content.Context
import android.util.DisplayMetrics
import kotlin.math.roundToInt

object Utils {
    fun pxToDp(context: Context, px: Int): Float {
        val displayMetrics = context.resources.displayMetrics
        return (px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt().toFloat()
    }

    fun dpToPx(context: Context, dp: Int): Float {
        val displayMetrics = context.resources.displayMetrics
        return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt().toFloat()
    }

}