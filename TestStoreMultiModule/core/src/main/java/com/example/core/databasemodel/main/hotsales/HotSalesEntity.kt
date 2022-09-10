package com.example.core.databasemodel.main.hotsales

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hot_sales")
class HotSalesEntity(
    @PrimaryKey
    val id: Int,
    val is_new: Boolean,
    val title: String,
    val subtitle: String,
    val picture: String,
    val is_buy: Boolean
)