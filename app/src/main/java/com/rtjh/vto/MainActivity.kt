package com.rtjh.vto

import android.os.Bundle
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import com.rtjh.vto.databinding.ActivityMainBinding
import com.rtjh.vto.databinding.CustomBottomNavigationBinding
import com.rtjh.vto.helper.BottomNavigationHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var customBottomNavigationBinding : CustomBottomNavigationBinding
    private lateinit var bottomNavigationHelper : BottomNavigationHelper

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        customBottomNavigationBinding = CustomBottomNavigationBinding.bind(binding.navView)
        setContentView(binding.root)
        bottomNavigationHelper = BottomNavigationHelper(this, customBottomNavigationBinding)
        val navController = bottomNavigationHelper.getNavController(supportFragmentManager)
        navController?.let { bottomNavigationHelper.setNavClickListener(it) }
        // 在 Activity 的 onCreate 方法中添加以下代码
        val controller = window.insetsController
        controller?.hide(WindowInsets.Type.statusBars())
    }


}