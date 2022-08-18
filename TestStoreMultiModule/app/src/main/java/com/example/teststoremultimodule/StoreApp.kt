package com.example.teststoremultimodule

import android.app.Application
import com.example.basket_screen.di.BasketScreenProvider
import com.example.di.DetailScreenProvider
import com.example.main_screen.di.MaineScreenProvider
import com.example.teststoremultimodule.di.AppComponent
import com.example.teststoremultimodule.di.DaggerAppComponent


class StoreApp : Application() {

    private val appComponent:AppComponent by lazy {
        DaggerAppComponent.create()
    }

    override fun onCreate() {
        super.onCreate()
        MaineScreenProvider.deps = appComponent
        BasketScreenProvider.deps = appComponent
        DetailScreenProvider.deps = appComponent
    }
}
