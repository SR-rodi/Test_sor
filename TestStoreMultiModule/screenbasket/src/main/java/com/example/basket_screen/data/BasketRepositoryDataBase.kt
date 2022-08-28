package com.example.basket_screen.data

import com.example.core.databasemodel.basket.BasketDao
import com.example.core.databasemodel.basket.BasketEntity
import javax.inject.Inject

class BasketRepositoryDataBase @Inject constructor(
    private val basketDao: BasketDao
) {
    fun getBasketFromDataBase() = basketDao.getAll()

    fun addToBasketDataBase(base: BasketEntity) = basketDao.insert(base)
}

