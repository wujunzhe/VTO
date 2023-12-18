package com.rtjh.vto.helper

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.rtjh.vto.R
import com.rtjh.vto.databinding.CustomBottomNavigationBinding

class BottomNavigationHelper(private val context: Context, private val binding: CustomBottomNavigationBinding) {
    private val navHome = binding.navigationHome
    private val navControl = binding.navigationControl
    private val navSetting = binding.navigationSetting

    fun setNavClickListener(navController: NavController) {
        setMenuItemActive(navHome, R.drawable.icon_home_active)
        navHome.setOnClickListener {
            navigateAndSetState(navController, R.id.navigation_home, navHome, R.drawable.icon_home_active)
        }
        navControl.setOnClickListener {
            navigateAndSetState(navController, R.id.navigation_control, navControl, R.drawable.icon_control_active)
        }
        navSetting.setOnClickListener {
            navigateAndSetState(navController, R.id.navigation_setting, navSetting, R.drawable.icon_setting_active)
        }
    }

    fun getNavController(fragmentManager: FragmentManager): NavController? {
        val navHostFragment = fragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as? NavHostFragment
        return navHostFragment?.navController
    }

    private fun navigateAndSetState(navController: NavController, destinationId: Int, navView: LinearLayout, activeIconResId: Int) {
        // 在导航前，先将其他项置为未激活状态
        setMenuItemInactive(navHome, R.drawable.icon_home)
        setMenuItemInactive(navControl, R.drawable.icon_control)
        setMenuItemInactive(navSetting, R.drawable.icon_setting)

        // 导航到目标页面
        navController.navigate(destinationId)

        // 设置当前项为激活状态
        setMenuItemActive(navView, activeIconResId)
    }

    private fun setMenuItemActive(navView: LinearLayout, activeIconResId: Int) {
        // 设置激活状态下的背景图标和文字颜色
        val activeIconDrawable = ContextCompat.getDrawable(context, activeIconResId)
        val activeTextColor = ContextCompat.getColor(context, R.color.menu_active_color)

        // 设置图标
        val iconImageView = navView.getChildAt(0) as ImageView
        iconImageView.setImageDrawable(activeIconDrawable)

        // 设置文字颜色
        val textView = navView.getChildAt(1) as TextView
        textView.setTextColor(activeTextColor)
    }

    private fun setMenuItemInactive(navView: LinearLayout, inactiveIconResId: Int) {
        // 设置未激活状态下的背景图标和文字颜色
        val inactiveIconDrawable = ContextCompat.getDrawable(context, inactiveIconResId)
        val inactiveTextColor = ContextCompat.getColor(context, R.color.menu_text_default_color)

        // 设置图标
        val iconImageView = navView.getChildAt(0) as ImageView
        iconImageView.setImageDrawable(inactiveIconDrawable)

        // 设置文字颜色
        val textView = navView.getChildAt(1) as TextView
        textView.setTextColor(inactiveTextColor)
    }
}

