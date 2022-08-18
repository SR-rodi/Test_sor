package com.example.core.dto.mainscreen.nesteddto

data class HotSaleDto(
    val id: Int,
    val is_new: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
)
