package com.example.core.dtomodel.mainscreen.nesteddto

data class HotSaleDto(
    val id: Int,
    val is_new: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
)
