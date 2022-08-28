package com.example.main_screen.domain

import com.example.core.dtomodel.mainscreen.nesteddto.BestSellerDto
import com.example.core.dtomodel.mainscreen.nesteddto.HotSaleDto

interface Repository {

    suspend fun getBestsellerFromNetwork():List<BestSellerDto>

    suspend fun getHotSaleFromNetwork():List<HotSaleDto>
}