package com.rtjh.vto.model

data class SchedulingInfoDataModel(
    val surgeryName: String,
    val patient: String,
    val surgeon: String,
    val nurse: String,
    val surgeryTime: String,
    val surgeryStatus: String
)