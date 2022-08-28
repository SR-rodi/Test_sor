package com.example.data

import com.example.core.databasemodel.detail.DetailDao
import com.example.core.databasemodel.detail.DetailEntity
import javax.inject.Inject

class DetailRepositoryDataBase @Inject constructor(
    private val detailDao: DetailDao
) {
    fun getDetailFromDataBase() = detailDao.getAll()

    fun  addToDetailDataBase(detailEntity: DetailEntity)= detailDao.insert(detailEntity)
}