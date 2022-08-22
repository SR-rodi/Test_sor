package com.example.basket_screen.repository

import com.example.core.dto.basketscreen.BasketDto
import com.example.core.dto.basketscreen.BasketPhoneDto

interface BasketRepository {
    suspend fun getBasket():BasketPhoneDto
}