package com.example.di

import com.example.teststore.network.api.StoreApi

// публичный интерфейс для внешних зависимостей
interface DetailScreenDependencies {
    val store: StoreApi
}
