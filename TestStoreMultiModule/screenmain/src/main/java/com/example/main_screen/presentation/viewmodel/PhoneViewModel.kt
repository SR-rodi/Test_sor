package com.example.main_screen.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.core.fragment.BaseViewModel
import com.example.core.dtomodel.mainscreen.nesteddto.BestSellerDto
import com.example.core.dtomodel.mainscreen.nesteddto.HotSaleDto
import com.example.core.tools.*
import com.example.main_screen.data.DataBaseRepository
import com.example.main_screen.data.NetworkRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhoneViewModel @Inject constructor(
    private val networkRepository: NetworkRepositoryImpl,
    private val dataBaseRepository: DataBaseRepository
) : BaseViewModel() {

    private val _isBestSeller = MutableStateFlow<List<BestSellerDto>>(emptyList())
    val isBestSeller = _isBestSeller.asStateFlow()

    private val _isHotSales = MutableStateFlow<List<HotSaleDto>>(emptyList())
    val isHotSales = _isHotSales.asStateFlow()

    fun getInfoBestSeller() = viewModelScope.launch(handler + Dispatchers.IO) {
        val isBestSellerDataBase = dataBaseRepository.getBestSellerFromDataBase()
        _isLoading.value = true
        if (isBestSellerDataBase.isEmpty()) {
            val isBestSellerNetwork = networkRepository.getBestsellerFromNetwork()
            isBestSellerNetwork.toBestSellerEntity().forEach { bestSellerEntity ->
                dataBaseRepository.addBestsellerToDataBase(bestSellerEntity)
            }
            Log.e("Mart", "Грузим из интернета")
            _isBestSeller.value = isBestSellerNetwork
        } else {
            Log.e("Mart", "Грузим из Базы данных")
            _isBestSeller.value = isBestSellerDataBase.toBestSellerDto()
        }
        _isLoading.value = false
    }

    fun getInfoHotSale() = viewModelScope.launch(handler + Dispatchers.IO) {
        val isHotSalesDataBase = dataBaseRepository.getHotSalesFromDataBase()
        _isLoading.value = true
        if (isHotSalesDataBase.isEmpty()) {
            val isHotSalesNetwork = networkRepository.getHotSaleFromNetwork()
            isHotSalesNetwork.toHotSalesEntity().forEach { hotSalesEntity ->
                dataBaseRepository.addHotSalesToDataBase(hotSalesEntity)
            }
            Log.e("Mart", "Грузим из интернета")
            _isHotSales.value = isHotSalesNetwork
        } else {
            Log.e("Mart", "Грузим из Базы данных")
            _isHotSales.value = isHotSalesDataBase.toHotSalesDto()
        }
        _isLoading.value = false
    }
}