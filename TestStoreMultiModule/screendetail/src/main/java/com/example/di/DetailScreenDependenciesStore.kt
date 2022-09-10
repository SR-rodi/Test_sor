package com.example.di

import kotlin.properties.Delegates

//объект который хранит в себе зависимости
object DetailScreenDependenciesStore : DetailScreenProvider {
    override var deps: DetailScreenDependencies by Delegates.notNull()

}
