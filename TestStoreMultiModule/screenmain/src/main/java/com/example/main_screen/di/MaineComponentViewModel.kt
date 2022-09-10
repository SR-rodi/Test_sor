package com.example.main_screen.di

import androidx.lifecycle.ViewModel
// задача вью модели сохранять дагер компонент на протежении жизни фичи
internal class MaineComponentViewModel : ViewModel() {
    val newMaineComponent: MainScreenComponent =
        DaggerMainScreenComponent.builder()
            .mainScreenDependencies(MaineScreenProvider.deps).build()

}