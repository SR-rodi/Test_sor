package com.example.basket_screen.data

import com.example.stor_api.api.StoreApi
import javax.inject.Inject

class BasketRepositoryNetwork @Inject constructor(
    private val storeApi: StoreApi
) {

    suspend fun getBasketFromNetwork() = storeApi.getBasketIndo()

}