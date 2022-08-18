package com.example.main_screen.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.main_screen.presentation.viewmodel.PhoneViewModel
import com.example.main_screen.repository.MainRepository
import javax.inject.Inject

class PhoneViewModelFactory @Inject constructor(
    private val
    repository: MainRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //вслучае ошибки выдает исключение IllegalArgumentException
        require(modelClass == PhoneViewModel::class.java)
        return PhoneViewModel(repository) as T
    }
}
