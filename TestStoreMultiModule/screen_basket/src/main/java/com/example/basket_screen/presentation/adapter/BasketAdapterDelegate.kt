package com.example.basket_screen.presentation.adapter

import android.annotation.SuppressLint
import com.example.basket_screen.databinding.ItemBasketBinding
import com.example.core.DOLLAR
import com.example.core.dto.basketscreen.BasketDto
import com.example.core.loadingGlide
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding


class BasketAdapterDelegate(listBasket: List<BasketDto>) :
    ListDelegationAdapter<List<BasketDto>>() {

    init {
        delegatesManager.addDelegate(basketAdapterDelegate())
        setItems(listBasket)
    }
}



