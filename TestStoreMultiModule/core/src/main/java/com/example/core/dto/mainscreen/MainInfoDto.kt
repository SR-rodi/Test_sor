package com.example.teststore.network.dto.mainscreen

import com.example.core.dto.mainscreen.nesteddto.BestSellerDto
import com.example.core.dto.mainscreen.nesteddto.HotSaleDto
import com.google.gson.annotations.SerializedName

class MainInfoDto(
    @SerializedName("home_store") val homeStore: List<HotSaleDto>,
    @SerializedName("best_seller")val bestSeller: List<BestSellerDto>
)
