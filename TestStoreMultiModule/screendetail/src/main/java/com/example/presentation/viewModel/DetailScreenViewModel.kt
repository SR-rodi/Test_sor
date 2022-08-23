package com.example.presentation.viewModel

import androidx.lifecycle.viewModelScope
import com.example.core.BaseViewModel
import com.example.data.DetailRepository
import com.example.core.dto.detailscreen.DetailInfoDto
import com.example.domain.DetailUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailScreenViewModel @Inject constructor(
    private val useCase: DetailUseCase
) : BaseViewModel() {

    private val _isInfo = MutableSharedFlow<DetailInfoDto>()
    val isInfo get() = _isInfo.asSharedFlow()

    fun getInfo() =
        viewModelScope.launch(handler) {
            _isLoading.value = true
            _isInfo.emit(useCase.getInfoDetails())
            _isLoading.value = false
        }
}