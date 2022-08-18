package com.example.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.R
import com.example.core.loadingGlide
import com.example.screen_detail.databinding.ItemDetailBinding

class DetailViewHolder(private val binding: ItemDetailBinding) :
    RecyclerView.ViewHolder(binding.root) {
    //тут не использую экстеншен потому что при добавление placeholder() и error() базовая картинка
    // уменьшается до самых минимальных размеров и смещается в левый верхний угол
    fun bindInfo(item: String) =
        Glide.with(binding.root)
            .load(item)
            .into(binding.detailImage)

}