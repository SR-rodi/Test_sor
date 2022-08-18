package com.example.main_screen.presentation.adapters.hotsales

import androidx.recyclerview.widget.RecyclerView
import com.example.main_screen.databinding.ItemHotSelesBinding

import com.example.core.dto.mainscreen.nesteddto.HotSaleDto
import com.example.core.loadingGlide

class HotSalesViewHolder(private val binding: ItemHotSelesBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: HotSaleDto) {

        if (item.is_new) binding.newLabel.alpha = 1f
        else binding.newLabel.alpha = 0f
        binding.title.text = item.title
        binding.subtitle.text = item.subtitle
        binding.imageView2.loadingGlide(item.picture)
    }
}
