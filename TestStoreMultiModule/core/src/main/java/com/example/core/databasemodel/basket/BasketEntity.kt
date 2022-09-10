package com.example.core.databasemodel.basket


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.dtomodel.basketscreen.BasketDto

@Entity(tableName = "basket")
data class BasketEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "delivery")
    val delivery: String,
    @ColumnInfo(name = "total")
    val total: Int,
    @ColumnInfo(name="listBasket")
    val listBasket: List<BasketDto>
)
