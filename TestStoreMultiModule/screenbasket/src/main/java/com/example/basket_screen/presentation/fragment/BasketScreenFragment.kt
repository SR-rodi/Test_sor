package com.example.basket_screen.presentation.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.example.basket_screen.R
import com.example.basket_screen.di.BasketComponentViewModel
import com.example.basket_screen.databinding.FragmentBasketScreenBinding
import com.example.core.DOLLAR
import com.example.core.TRANSITION_NAME
import com.example.navigation.createExtras
import com.example.basket_screen.presentation.viewModel.BasketViewModel
import com.example.core.BaseFragment
import com.example.basket_screen.presentation.adapter.BasketAdapter
import com.example.basket_screen.presentation.viewModel.BasketViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class BasketScreenFragment :
    BaseFragment<FragmentBasketScreenBinding>(R.layout.fragment_basket_screen) {

    override fun initBinding(inflater: LayoutInflater) =
        FragmentBasketScreenBinding.inflate(inflater)

    private val viewModel by viewModels<BasketViewModel> { factory }

    @Inject
    lateinit var factory: BasketViewModelFactory

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<BasketComponentViewModel>()
            .newBasketComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getInfo()

        isErrorInternet(viewModel.errorInternet)

        isLoading(viewModel.isLoading, binding.progressCircular)

        startAnimation()

        bindingInfo()

        newNavigationClickListener(
            binding.goBack,
            R.id.action_basketScreenFragment_to_mainFragment,
            createExtras(binding.backgroundOne, TRANSITION_NAME)
        )
    }

    @SuppressLint("SetTextI18n")
    private fun bindingInfo() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isBasket.collect {
                val a = it.listBasket
                binding.recyclerBasket.adapter = BasketAdapter(it.listBasket)
                binding.total.text = DOLLAR + it.total.toString()
                binding.delivery.text = it.delivery
            }
        }
    }

    private fun startAnimation() {
        binding.basketScreen.animate()
            .alpha(1f)
            .setDuration(700L)
            .start()
    }


}
