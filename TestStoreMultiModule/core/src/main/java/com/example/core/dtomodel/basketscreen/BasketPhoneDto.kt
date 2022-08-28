package com.example.core.dtomodel.basketscreen

import com.google.gson.annotations.SerializedName

data class BasketPhoneDto(
    @SerializedName("basket")  val listBasket: List<BasketDto>,
     val delivery: String,
     val id: String,
     val total: Int
)
