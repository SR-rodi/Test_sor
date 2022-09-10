package com.example.basket_screen.domain

import com.example.basket_screen.data.BasketRepositoryNetwork
import javax.inject.Inject

class BasketUseCase @Inject constructor(private val repository: BasketRepositoryNetwork) {

    suspend fun getBasketFromNetwork() = repository.getBasketFromNetwork()

}