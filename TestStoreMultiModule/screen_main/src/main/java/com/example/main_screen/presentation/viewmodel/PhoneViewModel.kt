package com.example.main_screen.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.core.BaseViewModel
import com.example.core.dto.mainscreen.nesteddto.BestSellerDto
import com.example.core.dto.mainscreen.nesteddto.HotSaleDto
import com.example.main_screen.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhoneViewModel @Inject constructor(
    private val repository: MainRepository
) : BaseViewModel() {

    private val _isBestSeller = MutableStateFlow<List<BestSellerDto>>(emptyList())
    val isBestSeller = _isBestSeller.asStateFlow()

    private val _isHotSales = MutableStateFlow<List<HotSaleDto>>(emptyList())
    val isHotSales = _isHotSales.asStateFlow()

    fun getInfoBestSeller() = viewModelScope.launch(context = handler) {
        _isLoading.value = true
        _isBestSeller.value = repository.getInfoBestseller()
        _isLoading.value = false
    }

    fun getInfoHotSale() = viewModelScope.launch(context = handler) {
        _isLoading.value = true
        _isHotSales.value = repository.getInfoHotSale()
        _isLoading.value = false
    }
}