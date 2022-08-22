package com.example.basket_screen.presentation.view_model

import androidx.lifecycle.viewModelScope
import com.example.basket_screen.repository.BasketRepositoryImpl
import com.example.core.BaseViewModel
import com.example.core.dto.basketscreen.BasketPhoneDto
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class BasketViewModel(
    private val repository: BasketRepositoryImpl
) : BaseViewModel() {

    private var _isBasket = MutableSharedFlow<BasketPhoneDto>()
    val isBasket = _isBasket.asSharedFlow()

    fun getInfo() {
        viewModelScope.launch(handler) {
            _isLoading.value = true
            _isBasket.emit(repository.getBasket())
            _isLoading.value = false
        }
    }
}