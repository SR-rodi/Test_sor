package com.example.presentation.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.core.fragment.BaseViewModel
import com.example.core.dtomodel.detailscreen.DetailInfoDto
import com.example.core.tools.toDto
import com.example.core.tools.toEntity
import com.example.data.DetailRepositoryDataBase
import com.example.domain.DetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailScreenViewModel @Inject constructor(
    private val networkUseCase: DetailUseCase,
    private val repositoryDataBase: DetailRepositoryDataBase,
) : BaseViewModel() {

    private val _isInfo = MutableSharedFlow<DetailInfoDto>()
    val isInfo get() = _isInfo.asSharedFlow()

    fun getInfo() =
        viewModelScope.launch(handler + Dispatchers.IO) {
            _isLoading.value = true
            val detailsFromDataBase = repositoryDataBase.getDetailFromDataBase()
            if (detailsFromDataBase == null) {
                val detailsFromNetwork = networkUseCase.getInfoDetails()
                repositoryDataBase.addToDetailDataBase(detailsFromNetwork.toEntity())
                _isInfo.emit(detailsFromNetwork)
                Log.e("Mart", "Грузим из интернета")
            } else {
                _isInfo.emit(detailsFromDataBase.toDto())
                Log.e("Mart", "Грузим из базы данных")
            }
            _isLoading.value = false
        }
}