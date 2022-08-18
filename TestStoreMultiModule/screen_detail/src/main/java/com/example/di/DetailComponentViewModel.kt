package com.example.di

import androidx.lifecycle.ViewModel

// задача вью модели сохранять дагер компонент на протежении жизни фичи
internal class DetailComponentViewModel : ViewModel() {
    val newDetailComponent: DetailComponent =
        DaggerDetailComponent
            .builder()
            .detailScreenDependencies(DetailScreenProvider.deps).build()
}