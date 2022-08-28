package com.example.teststoremultimodule.di

import android.content.Context
import com.example.storeroomdatabase.basket.AppDataBaseBasket
import com.example.storeroomdatabase.basket.initBasketDataBase


import com.example.stor_api.api.storeApi
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    fun providerStoreService() = storeApi()

    @Provides
    fun providerBasketDataBase(context: Context) = initBasketDataBase(context)

    @Provides
    fun providerBasketDao(appDataBase: AppDataBaseBasket) = appDataBase.basketDao()

    @Provides
    fun providerDetailDao(appDataBase: AppDataBaseBasket) = appDataBase.detailDao()

    @Provides
    fun providerHotSaleDao(appDataBase: AppDataBaseBasket) = appDataBase.hotSalesDao()

    @Provides
    fun providerBestSellerDao(appDataBase: AppDataBaseBasket) = appDataBase.bestSellerDao()


}
