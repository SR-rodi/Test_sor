package com.example.basket_screen.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basket_screen.repository.BasketRepository
import com.example.basket_screen.repository.BasketRepositoryImpl
import javax.inject.Inject

class BasketViewModelFactory @Inject constructor(
    private val repository: BasketRepositoryImpl
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == BasketViewModel::class.java)
        return BasketViewModel(repository) as T
    }
}