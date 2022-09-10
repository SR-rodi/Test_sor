package com.example.basket_screen.di

import com.example.core.CoroutinesDispatchersWrapper
import com.example.core.databasemodel.basket.BasketDao
import com.example.stor_api.api.StoreApi

interface BasketScreenDependencies{

    val store: StoreApi
    val baseBasket: BasketDao
    val dispatchersWrapper: CoroutinesDispatchersWrapper

}


