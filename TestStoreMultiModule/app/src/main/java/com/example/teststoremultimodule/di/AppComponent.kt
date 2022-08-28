package com.example.teststoremultimodule.di


import android.content.Context
import com.example.basket_screen.di.BasketScreenDependencies
import com.example.core.databasemodel.basket.BasketDao
import com.example.core.databasemodel.detail.DetailDao
import com.example.core.databasemodel.main.bestseller.BestSellerDao
import com.example.core.databasemodel.main.hotsales.HotSalesDao
import com.example.di.DetailScreenDependencies
import com.example.main_screen.di.MainScreenDependencies

import com.example.stor_api.api.StoreApi
import dagger.BindsInstance

import dagger.Component

@Component(modules = [AppModule::class] )
interface AppComponent : MainScreenDependencies,
    BasketScreenDependencies,
    DetailScreenDependencies {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun context(context: Context):Builder

        fun build():AppComponent


    }

    override val bestSellerDao: BestSellerDao
    override val hotSaleDao: HotSalesDao
    override val baseDetail: DetailDao
    override val baseBasket: BasketDao
    override val store: StoreApi
}




