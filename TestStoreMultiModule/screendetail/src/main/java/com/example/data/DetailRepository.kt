package com.example.data

import com.example.teststore.network.api.StoreApi
import javax.inject.Inject

class DetailRepository @Inject constructor(private val storeApi: StoreApi) {

    suspend fun getInfoDetails() = storeApi.getDetailInfo()

}
