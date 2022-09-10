package com.example.main_screen.di

// интерфейс который реализуется в не этого модуля что бы предоставить зависимости
interface MaineScreenProvider {
    var deps: MainScreenDependencies

    companion object : MaineScreenProvider by MainScreenDependenciesStore

}