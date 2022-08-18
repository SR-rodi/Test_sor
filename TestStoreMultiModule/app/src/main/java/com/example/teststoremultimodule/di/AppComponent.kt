package com.example.teststoremultimodule.di


import com.example.basket_screen.di.BasketScreenDependencies
import com.example.di.DetailScreenDependencies
import com.example.main_screen.di.MainScreenDependencies
import com.example.teststore.network.api.StoreApi

import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppComponent : MainScreenDependencies,
    BasketScreenDependencies,
    DetailScreenDependencies {

    override val store: StoreApi
}




