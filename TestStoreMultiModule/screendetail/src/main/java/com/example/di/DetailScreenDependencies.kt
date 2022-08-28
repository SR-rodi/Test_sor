package com.example.di

import com.example.core.databasemodel.detail.DetailDao
import com.example.stor_api.api.StoreApi

// публичный интерфейс для внешних зависимостей
interface DetailScreenDependencies {
    val store: StoreApi
    val baseDetail: DetailDao
}
