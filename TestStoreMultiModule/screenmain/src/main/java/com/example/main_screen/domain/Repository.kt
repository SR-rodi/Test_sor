package com.example.main_screen.domain

import com.example.core.dto.mainscreen.nesteddto.BestSellerDto
import com.example.core.dto.mainscreen.nesteddto.HotSaleDto

interface Repository {

    suspend fun getInfoBestseller():List<BestSellerDto>

    suspend fun getInfoHotSale():List<HotSaleDto>
}