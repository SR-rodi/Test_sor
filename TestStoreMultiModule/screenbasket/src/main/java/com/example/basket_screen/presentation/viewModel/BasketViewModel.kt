package com.example.basket_screen.presentation.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.basket_screen.data.BasketRepositoryDataBase
import com.example.basket_screen.domain.BasketUseCase
import com.example.core.CoroutinesDispatchersWrapper
import com.example.core.DispatchersWrapper
import com.example.core.databasemodel.basket.BasketEntity
import com.example.core.fragment.BaseViewModel
import com.example.core.tools.toEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class BasketViewModel(
    private val basketUseCase: BasketUseCase,
    private val dataBase: BasketRepositoryDataBase,
    private val dispatcherIo: CoroutineDispatcher = Dispatchers.IO
) : BaseViewModel() {

    private var _isBasket = MutableSharedFlow<BasketEntity>(replay = 1)
    val isBasket = _isBasket.asSharedFlow()
     var isDataBaseInfo:BasketEntity? =null
    var testText ="no create"

    fun getInfo() {
        viewModelScope.launch(handler + dispatcherIo) {

            _isLoading.value = true
             isDataBaseInfo = dataBase.getBasketFromDataBase()

            if (isDataBaseInfo == null) {

                val network = basketUseCase.getBasketFromNetwork()
                dataBase.addToBasketDataBase(network.toEntity())

               // Log.e("Mart", "грузим с интернета")
                _isBasket.emit(network.toEntity())
            } else {
                testText ="is create"
               _isBasket.emit(isDataBaseInfo!!)
            }
            _isLoading.value = false
        }
    }
}