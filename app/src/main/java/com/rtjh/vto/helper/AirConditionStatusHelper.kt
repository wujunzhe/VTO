package com.rtjh.vto.helper

import androidx.core.content.ContextCompat
import com.rtjh.vto.R
import com.rtjh.vto.databinding.ControlAirConditionModuleBinding

class AirConditionStatusHelper(binding: ControlAirConditionModuleBinding) {
    private val context = binding.root.context
    private val temCircleView = binding.tempCircle
    private val temStartColor = ContextCompat.getColor(context, R.color.tem_circle_start_color)
    private val temEndColor = ContextCompat.getColor(context,R.color.tem_circle_end_color)
    private val humCircleView = binding.humCircle
    private val humStartColor = ContextCompat.getColor(context,R.color.hum_circle_start_color)
    private val humEndColor = ContextCompat.getColor(context, R.color.hum_circle_end_color)
    private val dpCircleView = binding.differentPressureCircle
    private val dpStartColor = ContextCompat.getColor(context, R.color.d_p_circle_start_color)
    private val dpEndColor = ContextCompat.getColor(context, R.color.d_p_circle_end_color)

    init {
        initTemCircle()
        initHumCircle()
        initDpCircle()

    }

    private fun initTemCircle(){
        temCircleView.setIsGradient(true)
        temCircleView.setGradientColors(intArrayOf(temStartColor,temEndColor))
        temCircleView.setValue("15",30f)
    }

    private fun initHumCircle(){
        humCircleView.setIsGradient(true)
        humCircleView.setGradientColors(intArrayOf(humStartColor, humEndColor))
        humCircleView.setValue("40",70f)
    }

    private fun initDpCircle(){
        dpCircleView.setIsGradient(true)
        dpCircleView.setGradientColors(intArrayOf(dpStartColor,dpEndColor))
        dpCircleView.setValue("50", 80f)
    }
}