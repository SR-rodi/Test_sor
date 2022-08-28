package com.example.basket_screen.presentation.adapter

import android.annotation.SuppressLint
import com.example.basket_screen.databinding.ItemBasketBinding
import com.example.core.tools.DOLLAR
import com.example.core.dtomodel.basketscreen.BasketDto
import com.example.core.tools.loadingGlide
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

@SuppressLint("SetTextI18n")
fun basketAdapterDelegate() =
    adapterDelegateViewBinding<BasketDto, BasketDto, ItemBasketBinding>(
        { layoutInflater, root -> ItemBasketBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.apply {
                nameItem.text = item.title
                price.text = DOLLAR + item.price
                itemPhoto.loadingGlide(item.images)
            }
        }
    }