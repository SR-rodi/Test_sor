package com.example.core.dto.mainscreen.nesteddto

data class BestSellerDto(
    val id: Int,
    var is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
)
