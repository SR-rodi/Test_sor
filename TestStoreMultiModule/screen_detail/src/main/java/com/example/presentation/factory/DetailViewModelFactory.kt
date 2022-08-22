package com.example.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.repository.DetailRepository
import com.example.presentation.viewModel.DetailScreenViewModel
import javax.inject.Inject

class DetailViewModelFactory @Inject constructor(
    private val
    repository: DetailRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(modelClass == DetailScreenViewModel::class.java)
        return DetailScreenViewModel(repository) as T
    }
}