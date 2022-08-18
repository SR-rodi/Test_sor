package com.example.main_screen.presentation.adapters.pager_adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.main_screen.presentation.fragment.MainFragment

import com.example.main_screen.presentation.fragment.PhoneFragment

class CategoryPagerAdapter(fragment: MainFragment,
private val onClick:()->Unit):FragmentStateAdapter(fragment) {
    override fun getItemCount()=6

    override fun createFragment(position: Int): Fragment {
       return when (position) {
            0-> PhoneFragment { onClick() }
           else ->Fragment()
        }
    }
}