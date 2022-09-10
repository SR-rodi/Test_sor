package com.example.data

import com.example.stor_api.api.StoreApi
import javax.inject.Inject

class DetailRepositoryNetwork @Inject constructor(private val storeApi: StoreApi) {

    suspend fun getInfoDetails() = storeApi.getDetailInfo()

}
