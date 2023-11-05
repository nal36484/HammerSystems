package com.example.test.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.test.presentation.basket.BasketFragment
import com.example.test.presentation.menu.MenuFragment
import com.example.test.presentation.profile.ProfileFragment

class TabPageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private var numberOfTabs: Int
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return numberOfTabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MenuFragment()
            1 -> ProfileFragment()
            2 -> BasketFragment()
            else -> MenuFragment()
        }
    }
}