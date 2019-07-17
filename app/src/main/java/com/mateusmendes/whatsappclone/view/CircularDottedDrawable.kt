package com.mateusmendes.whatsappclone.view

import android.content.res.Resources
import android.graphics.drawable.GradientDrawable

class CircularDottedDrawable(
    val resources: Resources,
    color: Int,
    width: Float,
    dashWidth: Float,
    dashGap: Float
) : GradientDrawable() {

    init {
        setStroke(convertDpToPx(width).toInt(), color, convertDpToPx(dashWidth), convertDpToPx(dashGap))

        shape = OVAL
    }

    private fun convertDpToPx(dp: Float): Float {
        return dp * resources.displayMetrics.density
    }
}