package ru.example.testcanvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View

class SizeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textSize = 18f
    }

    override fun onLayout(
        changed: Boolean,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ) {
        super.onLayout(changed, left, top, right, bottom)

        val viewWidth = right - left
        val viewHeight = bottom - top

        Log.d(
            "ViewCanvasSize",
            "onLayout(): width = $viewWidth px, height = $viewHeight px"
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val canvasWidth = canvas.width
        val canvasHeight = canvas.height

        Log.d(
            "ViewCanvasSize",
            "onDraw(): width = $canvasWidth px, height = $canvasHeight px"
        )

        canvas.drawColor(Color.rgb(45, 95, 145))

        canvas.drawText(
            "View / Canvas size comparison",
            24f,
            48f,
            paint
        )

        canvas.drawText(
            "Canvas: ${canvasWidth} x ${canvasHeight} px",
            24f,
            82f,
            paint
        )
    }
}
