package com.example.basket_screen.domain

import com.example.basket_screen.data.BasketRepository
import com.example.teststore.network.api.StoreApi
import javax.inject.Inject

class BasketUseCase @Inject constructor(private val repository: BasketRepository) {

    suspend fun getBasket() = repository.getBasket()

}