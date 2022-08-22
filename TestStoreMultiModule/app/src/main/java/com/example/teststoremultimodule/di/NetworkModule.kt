package com.example.teststoremultimodule.di

import com.example.teststore.network.api.storeApi
import dagger.Module
import dagger.Provides

@Module
object NetworkModule{

    @Provides
    fun providerStoreService()= storeApi()


}
