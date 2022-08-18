package com.example.di

// интерфейс который реализуется в не этого модуля что бы предоставить зависимости
interface DetailScreenProvider {
    var deps: DetailScreenDependencies

    companion object : DetailScreenProvider by DetailScreenDependenciesStore

}