package com.amityeko.rnr.common.components.audio

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat

class WaveFormView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var paint = Paint()
    private var amplitudes = ArrayList<Float>()
    private var radious = 6f
    private var w = 9f
    private var spikes = ArrayList<RectF>()
    private var d = 6f
    private var sw = 0f
    private var sh = 200f
    private var maxSpikes = 0

    init {
        paint.color = Color.rgb(255, 255, 255)
        sw = resources.displayMetrics.widthPixels.toFloat()
        sh = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            58f,
            resources.displayMetrics
        )
        maxSpikes = (sw / (w + d)).toInt()
    }

    fun addAmplitude(amp: Float) {
        val norm = Math.min(amp.toInt() / 7, 200).toFloat()
        amplitudes.add(norm)
        spikes.clear()
        val amps = amplitudes.takeLast(maxSpikes)
        for (i in amps.indices) {
            val left = sw - i * (w + d)
            val top = sh / 2 - amps[i] / 2
            val right = left + w
            val bottom = top + amps[i]
            spikes.add(RectF(left, top, right, bottom))
        }

        invalidate()

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        spikes.forEach {
            canvas?.drawRoundRect(it, radious, radious, paint)
        }
    }
}