package com.example.core.databasemodel.basket

import androidx.room.TypeConverter
import com.example.core.dtomodel.basketscreen.BasketDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BasketConverter {

    @TypeConverter
    fun fromCountryLangList(value: List<BasketDto>): String {
        val gson = Gson()
        val type = object : TypeToken<List<BasketDto>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toCountryLangList(value: String): List<BasketDto> {
        val gson = Gson()
        val type = object : TypeToken<List<BasketDto>>() {}.type
        return gson.fromJson(value, type)
    }
}