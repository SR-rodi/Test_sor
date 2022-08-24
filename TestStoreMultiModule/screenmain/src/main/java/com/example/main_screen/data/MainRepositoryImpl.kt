package com.example.main_screen.data

import com.example.main_screen.domain.Repository
import com.example.teststore.network.api.StoreApi
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor (private val storeApi: StoreApi):Repository{

    override suspend fun getInfoBestseller() = storeApi.getMainInfo().bestSeller

    override suspend fun getInfoHotSale() = storeApi.getMainInfo().homeStore
}