package com.example.basket_screen.di

interface BasketScreenProvider {

    var deps: BasketScreenDependencies

    companion object : BasketScreenProvider by BasketScreenDependenciesStore

}



