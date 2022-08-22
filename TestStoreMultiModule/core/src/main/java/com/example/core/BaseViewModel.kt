package com.example.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.net.UnknownHostException

open class BaseViewModel:ViewModel() {

    protected val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _errorInternet = MutableStateFlow(false)
    val errorInternet = _errorInternet.asStateFlow()

    protected val handler = CoroutineExceptionHandler { _, T ->
        _errorInternet.value = T != UnknownHostException()
    }
}