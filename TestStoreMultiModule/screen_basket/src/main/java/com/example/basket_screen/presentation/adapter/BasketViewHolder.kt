package com.example.basket_screen.presentation.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.basket_screen.databinding.ItemBasketBinding
import com.example.core.DOLLAR
import com.example.core.loadingGlide
import com.example.core.dto.basketscreen.BasketDto


class BasketViewHolder(private val binding: ItemBasketBinding) :
    RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: BasketDto) =
        binding.apply {
            nameItem.text = item.title
            price.text = DOLLAR + item.price
            itemPhoto.loadingGlide(item.images)
        }
}
