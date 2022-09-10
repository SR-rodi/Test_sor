package com.example.main_screen.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.main_screen.data.DataBaseRepository
import com.example.main_screen.data.NetworkRepositoryImpl
import javax.inject.Inject

class PhoneViewModelFactory @Inject constructor(
    private val networkRepository: NetworkRepositoryImpl,
    private val dataBaseRepository: DataBaseRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //вслучае ошибки выдает исключение IllegalArgumentException
        require(modelClass == PhoneViewModel::class.java)
        return PhoneViewModel(networkRepository,dataBaseRepository) as T
    }
}