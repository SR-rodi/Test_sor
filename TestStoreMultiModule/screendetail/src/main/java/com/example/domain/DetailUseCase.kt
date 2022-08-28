package com.example.domain

import com.example.data.DetailRepositoryNetwork
import javax.inject.Inject

class DetailUseCase  @Inject constructor(private val repository: DetailRepositoryNetwork) {

    suspend fun getInfoDetails() = repository.getInfoDetails()

}
