package com.example.core.databasemodel.detail

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail")
class DetailEntity(
    @PrimaryKey
    val id: String,
    val CPU: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val images: List<String>,
    var isFavorites: Boolean,
    val price: Int,
    val rating: Double,
    val sd: String,
    val ssd: String,
    val title: String
)