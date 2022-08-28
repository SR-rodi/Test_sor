package com.example.main_screen.di

import com.example.core.databasemodel.main.bestseller.BestSellerDao
import com.example.core.databasemodel.main.hotsales.HotSalesDao
import com.example.stor_api.api.StoreApi

// публичный интерфейс для внешних зависимостей
interface MainScreenDependencies {

    val hotSaleDao:HotSalesDao
    val bestSellerDao:BestSellerDao
    val store: StoreApi
}