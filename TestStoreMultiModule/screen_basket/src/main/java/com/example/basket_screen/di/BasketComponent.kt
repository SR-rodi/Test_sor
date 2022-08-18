package com.example.basket_screen.di

import com.example.basket_screen.presentation.fragment.BasketScreenFragment
import com.example.core.Feature
import dagger.Component

//internal интерфейс виден только в модуле в котором лежит
@Feature
@Component(dependencies = [BasketScreenDependencies::class])
internal interface BasketComponent {
    fun inject(fragment: BasketScreenFragment)

    //Весь интерфейс это билдер для дагер коипонента служит для перетягивания внешних зависимостей
    interface BuilderOne {
        fun dependencies(dependencies: BasketScreenDependencies): BuilderOne //протянуть зависимость из вне
        fun build(): BasketComponent
    }
}

