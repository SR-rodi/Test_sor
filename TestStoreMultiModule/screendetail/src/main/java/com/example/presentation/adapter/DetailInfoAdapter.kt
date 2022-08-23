package com.example.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.core.dto.detailscreen.DetailInfoDto
import com.example.presentation.fragment.ShopFragment

class DetailInfoAdapter(
    fragment: Fragment,
    private val detailInfoDto: DetailInfoDto
) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ShopFragment(detailInfoDto)
            else -> Fragment()
        }
    }
}