package com.example.basket_screen.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basket_screen.data.BasketRepositoryDataBase
import com.example.basket_screen.domain.BasketUseCase
import javax.inject.Inject

class BasketViewModelFactory @Inject constructor(
    private val useCase: BasketUseCase,
    private val dataBase: BasketRepositoryDataBase,

    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == BasketViewModel::class.java)
        return BasketViewModel(useCase,dataBase) as T
    }


}