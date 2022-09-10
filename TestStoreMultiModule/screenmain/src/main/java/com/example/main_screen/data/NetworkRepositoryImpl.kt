package com.example.main_screen.data

import com.example.main_screen.domain.Repository
import com.example.stor_api.api.StoreApi
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor (private val storeApi: StoreApi):Repository{

    override suspend fun getBestsellerFromNetwork() = storeApi.getMainInfo().bestSeller

    override suspend fun getHotSaleFromNetwork() = storeApi.getMainInfo().homeStore
}