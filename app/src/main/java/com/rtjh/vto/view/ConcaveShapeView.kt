package com.rtjh.vto.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Typeface
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.rtjh.vto.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ConcaveShapeView(context : Context, attrs : AttributeSet? = null) : View(context, attrs) {

    private val concaveColor = ContextCompat.getColor(context, R.color.top_module_bg_color)
    private val concaveHeight = resources.getDimension(R.dimen.concave_height)
    private val concaveWidth = resources.getDimension(R.dimen.concave_width)
    private val viewHeight = resources.getDimension(R.dimen.top_module_height)  - 30
    private val viewWidth = 1080

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val companyName = "Your Company"
    private val centerText = "OR.56"

    private val handler = Handler()
    private val updateTimeRunnable = object : Runnable{
        override fun run() {
            invalidate()
            handler.postDelayed(this, 1000)
        }
    }
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        handler.post(updateTimeRunnable)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        handler.removeCallbacks(updateTimeRunnable)
    }


    init {
        paint.color = concaveColor
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val path = Path()

        // 左上角
        path.moveTo(0f, 0f)

        // 左下角
        path.lineTo(0f, viewHeight)

        // 绘制直线到居中位置
        path.lineTo((viewWidth - concaveWidth) / 2f, viewHeight)

        // 开始绘制凹陷
        path.lineTo((viewWidth - concaveWidth) / 2f, viewHeight)
        val controlPoint1X = (viewWidth - concaveWidth) / 2f
        val controlPoint1Y = viewHeight + concaveHeight / 2f
        val controlPoint2X = (viewWidth + concaveWidth) / 2f
        val controlPoint2Y = viewHeight + concaveHeight / 2f
        path.cubicTo(controlPoint1X, controlPoint1Y, controlPoint2X, controlPoint2Y, (viewWidth + concaveWidth) / 2, viewHeight)

                // 向右下方绘制矩形
        path.lineTo((viewWidth + concaveWidth) / 2, viewHeight + concaveHeight)
        path.lineTo((viewWidth + concaveWidth) / 2, viewHeight)

        // 向右上方绘制凹陷
        path.lineTo(viewWidth.toFloat(), viewHeight)

        path.lineTo(viewWidth.toFloat(),0f)

        canvas.drawPath(path, paint)

        // 绘制公司名称
        val textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.color = ContextCompat.getColor(context, R.color.top_module_text_color)
        textPaint.textSize = resources.getDimension(R.dimen.home_time_zh_text_size)
        canvas.drawText(companyName, 20f, viewHeight / 2f, textPaint)

        // 中间文字画笔
        val centerTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        centerTextPaint.color = ContextCompat.getColor(context, R.color.top_module_text_color)
        centerTextPaint.textSize = resources.getDimension(R.dimen.top_module_text_size)
        centerTextPaint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)

        // 绘制中间文字 "OR56"
        val centerTextWidth = centerTextPaint.measureText(centerText)
        val centerTextHeight = centerTextPaint.fontMetrics.bottom - centerTextPaint.fontMetrics.top
        val centerTextBaseline = viewHeight + (concaveHeight - centerTextHeight) / 2 - centerTextPaint.fontMetrics.bottom
        canvas.drawText(centerText, (viewWidth - centerTextWidth) / 2, centerTextBaseline, centerTextPaint)

        // 绘制右侧当地时间（包含年月日时分秒）
        val timeFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault())
        val currentTime = timeFormat.format(Date())
        canvas.drawText(currentTime, viewWidth - 320f, viewHeight / 2f + 10, textPaint)
    }
}