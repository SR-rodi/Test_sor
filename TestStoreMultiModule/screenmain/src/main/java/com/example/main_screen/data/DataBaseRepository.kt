package com.example.main_screen.data

import com.example.core.databasemodel.main.bestseller.BestSellerDao
import com.example.core.databasemodel.main.bestseller.BestSellerEntity
import com.example.core.databasemodel.main.hotsales.HotSalesDao
import com.example.core.databasemodel.main.hotsales.HotSalesEntity
import javax.inject.Inject

class DataBaseRepository @Inject constructor(
    private val hotSalesDao: HotSalesDao,
    private val bestSellerDao: BestSellerDao
) {
    fun getHotSalesFromDataBase() = hotSalesDao.getAll()

    fun addHotSalesToDataBase(hotSalesEntity: HotSalesEntity) =
        hotSalesDao.insert(hotSalesEntity)

    fun getBestSellerFromDataBase() = bestSellerDao.getAll()

    fun addBestsellerToDataBase(bestSellerEntity: BestSellerEntity) =
        bestSellerDao.insert(bestSellerEntity)
}