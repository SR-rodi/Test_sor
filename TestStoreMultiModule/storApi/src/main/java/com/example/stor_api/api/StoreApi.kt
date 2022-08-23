package com.example.teststore.network.api

import com.example.core.BASE_URL
import com.example.core.GET_BASKET
import com.example.core.GET_DETAILS
import com.example.core.GET_MAINE
import com.example.core.dto.basketscreen.BasketPhoneDto
import com.example.core.dto.detailscreen.DetailInfoDto
import com.example.teststore.network.dto.mainscreen.MainInfoDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET


interface StoreApi {

    @GET(GET_MAINE)
   suspend fun getMainInfo (): MainInfoDto

   @GET(GET_BASKET)
   suspend fun getBasketIndo(): BasketPhoneDto

   @GET(GET_DETAILS)
   suspend fun getDetailInfo(): DetailInfoDto
}


fun storeApi(): StoreApi {
   val retrofit: Retrofit =
      Retrofit.Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .build()

   return retrofit.create(StoreApi::class.java)
}



