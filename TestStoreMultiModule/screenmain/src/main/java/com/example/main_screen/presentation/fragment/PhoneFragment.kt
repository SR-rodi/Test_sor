package com.example.main_screen.presentation.fragment


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.core.fragment.BaseFragment

import com.example.main_screen.databinding.FragmentPhoneBinding
import com.example.main_screen.di.MaineComponentViewModel
import com.example.main_screen.presentation.adapters.bestseller.BestSellerAdapter
import com.example.main_screen.presentation.adapters.hotsales.HotSalesAdapter
import com.example.main_screen.presentation.viewmodel.PhoneViewModelFactory
import com.example.main_screen.presentation.viewmodel.PhoneViewModel
import javax.inject.Inject

class PhoneFragment(private val onClick: () -> Unit) : BaseFragment<FragmentPhoneBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentPhoneBinding.inflate(inflater)

    private val viewModel: PhoneViewModel by viewModels { factory }

    private val bestSellerAdapter by lazy {
        BestSellerAdapter { onClick() }
    }

    private val hotSalesAdapter by lazy { HotSalesAdapter() }

    @Inject
    lateinit var factory: PhoneViewModelFactory

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<MaineComponentViewModel>()
            .newMaineComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isErrorInternet(viewModel.errorInternet)

        isLoading(viewModel.isLoading, binding.progressBar)

        viewModel.getInfoBestSeller()
        viewModel.getInfoHotSale()

        PagerSnapHelper().attachToRecyclerView(binding.recyclerVewHotSales)

        binding.recyclerBestSeller.adapter = bestSellerAdapter
        binding.recyclerVewHotSales.adapter = hotSalesAdapter

        transferToAdapterBestSellers()
        transferToAdapterHotSales()
    }

    private fun transferToAdapterBestSellers() =
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.isBestSeller.collect {
                bestSellerAdapter.items = it
            }
        }

    private fun transferToAdapterHotSales() =
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.isHotSales.collect {
                hotSalesAdapter.items = it
            }
        }
}