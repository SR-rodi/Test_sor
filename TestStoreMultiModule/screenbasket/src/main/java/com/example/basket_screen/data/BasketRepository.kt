package com.example.basket_screen.data

import com.example.teststore.network.api.StoreApi
import javax.inject.Inject

class BasketRepository @Inject constructor(private val storeApi: StoreApi)
   {

    suspend fun getBasket() = storeApi.getBasketIndo()

}