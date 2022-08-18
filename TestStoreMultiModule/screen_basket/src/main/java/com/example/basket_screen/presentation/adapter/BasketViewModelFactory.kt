package com.example.teststore.presentation.basketscreen.adapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basket_screen.repository.BasketRepository
import com.example.basket_screen.presentation.view_model.BasketViewModel
import javax.inject.Inject

class BasketViewModelFactory @Inject constructor(
    private val repository: BasketRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == BasketViewModel::class.java)
        return BasketViewModel(repository) as T
    }
}