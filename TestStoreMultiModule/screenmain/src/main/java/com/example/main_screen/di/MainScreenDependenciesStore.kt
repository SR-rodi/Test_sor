package com.example.main_screen.di

import kotlin.properties.Delegates

//объект который хранит в себе зависимости
object MainScreenDependenciesStore : MaineScreenProvider {
    override var deps: MainScreenDependencies by Delegates.notNull()

}
