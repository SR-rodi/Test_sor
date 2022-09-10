package com.example.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.DetailRepositoryDataBase
import com.example.domain.DetailUseCase
import javax.inject.Inject

class DetailViewModelFactory @Inject constructor(
    private val networkUseCase: DetailUseCase,
    private val repositoryDataBase: DetailRepositoryDataBase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == DetailScreenViewModel::class.java)
        return DetailScreenViewModel(networkUseCase,repositoryDataBase) as T
    }
}