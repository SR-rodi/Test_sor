package com.example.domain

import com.example.data.DetailRepository
import com.example.teststore.network.api.StoreApi
import javax.inject.Inject

class DetailUseCase  @Inject constructor(private val repository: DetailRepository) {

    suspend fun getInfoDetails() = repository.getInfoDetails()

}
