package com.example.main_screen.di

import com.example.core.tools.Feature
import com.example.main_screen.presentation.fragment.PhoneFragment
import dagger.Component

//internal интерфейс виден только в модуле в котором лежит
@Feature
@Component(
    dependencies = [MainScreenDependencies::class],
)
internal interface MainScreenComponent {
    fun inject(fragment: PhoneFragment)

    //Весь интерфейс это билдер для дагер коипонента служит для перетягивания внешних зависимостей
    interface BuilderOne {
        fun dependencies(dependencies: MainScreenDependencies): BuilderOne //протянуть зависимость из вне
        fun build(): MainScreenComponent
    }
}



