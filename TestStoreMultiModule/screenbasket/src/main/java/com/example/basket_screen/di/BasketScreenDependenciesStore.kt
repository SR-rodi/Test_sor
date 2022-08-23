package com.example.basket_screen.di

import kotlin.properties.Delegates

object BasketScreenDependenciesStore : BasketScreenProvider {

    override var deps: BasketScreenDependencies by Delegates.notNull()

}