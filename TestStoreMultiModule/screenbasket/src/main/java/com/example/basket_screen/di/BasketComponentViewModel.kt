package com.example.basket_screen.di

import androidx.lifecycle.ViewModel

internal class BasketComponentViewModel : ViewModel() {

    val newBasketComponent: BasketComponent = DaggerBasketComponent.builder()
        .basketScreenDependencies(BasketScreenProvider.deps)
        .build()

}


