package com.example.main_screen.repository

import com.example.teststore.network.api.StoreApi
import javax.inject.Inject

class MainRepository @Inject constructor (private val storeApi: StoreApi){

    suspend fun getInfoBestseller() = storeApi.getMainInfo().bestSeller

    suspend fun getInfoHotSale() = storeApi.getMainInfo().homeStore
}