package com.example.main_screen.di

import com.example.teststore.network.api.StoreApi

// публичный интерфейс для внешних зависимостей
interface MainScreenDependencies {
    val store: StoreApi
}