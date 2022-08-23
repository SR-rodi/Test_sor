package com.example.basket_screen.presentation.adapter


import com.example.core.dto.basketscreen.BasketDto
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter


class BasketAdapter(listBasket: List<BasketDto>) :
    ListDelegationAdapter<List<BasketDto>>() {

    init {
        delegatesManager.addDelegate(basketAdapterDelegate())
        setItems(listBasket)
    }
}