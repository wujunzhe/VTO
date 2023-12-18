package com.rtjh.vto.view

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.util.AttributeSet
import android.view.View
import com.rtjh.vto.R

class ColoredDotView @JvmOverloads constructor(
    context : Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    init {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.ColoredDotView)
            val dotColor = a.getColor(R.styleable.ColoredDotView_dotColor, 0)
            a.recycle()

            // 设置圆点颜色
            setDotColor(dotColor)
        }
    }

    private fun setDotColor(color: Int) {
        val ovalShape = OvalShape()
        val shapeDrawable = ShapeDrawable(ovalShape)

        shapeDrawable.paint.color = color
        background = shapeDrawable
    }
}