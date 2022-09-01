package com.example.basket_screen.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.basket_screen.data.BasketRepositoryDataBase
import com.example.basket_screen.domain.BasketUseCase
import com.example.core.CoroutinesDispatchersWrapper
import com.example.core.DispatchersWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class BasketViewModelFactory @Inject constructor(
    private val useCase: BasketUseCase,
    private val dataBase: BasketRepositoryDataBase,
    private val dispatcher: CoroutinesDispatchersWrapper

    ) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == BasketViewModel::class.java)
        return BasketViewModel(useCase,dataBase,dispatcher) as T
    }


}

