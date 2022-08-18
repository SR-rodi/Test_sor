package com.example.presentation.view_model

import androidx.lifecycle.viewModelScope
import com.example.core.dto.BaseViewModel
import com.example.repository.DetailRepository
import com.example.core.dto.detailscreen.DetailInfoDto
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailScreenViewModel @Inject constructor(
    private val repository: DetailRepository
) : BaseViewModel() {

    private val _isInfo = MutableSharedFlow<DetailInfoDto>()
    val isInfo get() = _isInfo.asSharedFlow()

    fun getInfo() =
        viewModelScope.launch(handler) {
            _isLoading.value = true
            _isInfo.emit(repository.getInfoDetails())
            _isLoading.value = false
        }
}