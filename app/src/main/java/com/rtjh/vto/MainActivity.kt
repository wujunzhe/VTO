package com.rtjh.vto

import android.os.Bundle
import android.view.WindowInsets
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.rtjh.vto.databinding.ActivityMainBinding
import com.rtjh.vto.helper.BottomNavigationHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val bottomNavigationHelper = BottomNavigationHelper(this)
        bottomNavigationHelper.setupWithNavController(navView,navController)
        // 在 Activity 的 onCreate 方法中添加以下代码
        val controller = window.insetsController
        controller?.hide(WindowInsets.Type.statusBars())
    }
}