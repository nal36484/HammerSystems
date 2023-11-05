package com.example.test.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.test.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpTabBar()
    }

    private fun setUpTabBar() {
        val tabPageAdapter = TabPageAdapter(supportFragmentManager, lifecycle, 3)
        binding.viewPager.adapter = tabPageAdapter
    }
}