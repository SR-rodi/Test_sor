package com.example.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.DetailRepository
import com.example.domain.DetailUseCase
import javax.inject.Inject

class DetailViewModelFactory @Inject constructor(
    private val
    useCase: DetailUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == DetailScreenViewModel::class.java)
        return DetailScreenViewModel(useCase) as T
    }
}