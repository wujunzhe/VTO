package com.rtjh.vto.helper

import android.content.Context
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rtjh.vto.R

class BottomNavigationHelper(private val context : Context) {

    fun setupWithNavController(
        navView: BottomNavigationView,
        navController: NavController
    ) {
        val colorStateList = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_checked),
                intArrayOf(-android.R.attr.state_checked)
            ),
            intArrayOf(
                ContextCompat.getColor(context, R.color.menu_active_color),
                ContextCompat.getColor(context,R.color.menu_default_color)
            )
        )

        // 设置图标和文本颜色
        navView.itemIconTintList = colorStateList
        navView.itemTextColor = colorStateList

        // 设置激活菜单项
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_control,
                R.id.navigation_setting
            )
        )
        navView.setupWithNavController(navController)

        // 设置激活状态下的图标
        navView.menu.findItem(R.id.navigation_home).setIcon(R.drawable.icon_home_active)
        navView.menu.findItem(R.id.navigation_control).setIcon(R.drawable.icon_control_active)
        navView.menu.findItem(R.id.navigation_setting).setIcon(R.drawable.icon_setting_active)
    }
}