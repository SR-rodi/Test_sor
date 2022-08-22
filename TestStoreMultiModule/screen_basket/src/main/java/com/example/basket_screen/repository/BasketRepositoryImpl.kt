package com.example.basket_screen.repository

import com.example.teststore.network.api.StoreApi
import javax.inject.Inject

class BasketRepositoryImpl @Inject constructor(private val storeApi: StoreApi):BasketRepository {

    override suspend fun getBasket() = storeApi.getBasketIndo()

}