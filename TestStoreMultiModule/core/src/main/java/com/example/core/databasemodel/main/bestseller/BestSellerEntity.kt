package com.example.core.databasemodel.main.bestseller

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "best_seller")
class BestSellerEntity(
    @PrimaryKey
    val id: Int,
    var is_favorites: Boolean,
    val title: String,
    val price_without_discount: Int,
    val discount_price: Int,
    val picture: String
)