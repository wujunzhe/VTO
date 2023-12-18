package com.rtjh.vto.utils

class TypeUtils {
    companion object{
        fun isNum(value: String?): Boolean {
            try {
                value !!.toDouble()
            } catch (e: Exception) {
                return false
            }
            return true
        }
    }
}