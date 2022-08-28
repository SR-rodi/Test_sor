package com.example.di

import com.example.core.tools.Feature
import com.example.presentation.fragment.DetailScreenFragment
import dagger.Component

@Feature
@Component(dependencies = [DetailScreenDependencies::class],)
internal interface DetailComponent {
    fun inject(fragment: DetailScreenFragment)

    //Весь интерфейс это билдер для дагер коипонента служит для перетягивания внешних зависимостей
    interface BuilderOne {
        fun dependencies(dependencies: DetailScreenDependencies): BuilderOne //протянуть зависимость из вне
        fun build(): DetailComponent
    }
}









