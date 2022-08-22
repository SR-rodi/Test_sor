package com.example.presentation.fragment


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.presentation.adapter.DetailInfoAdapter
import com.example.core.BaseFragment
import com.example.core.DOLLAR
import com.example.core.TRANSITION_NAME
import com.example.di.DetailComponentViewModel
import com.example.navigation.createExtras
import com.example.presentation.adapter.DetailAdapter
import com.example.presentation.factory.DetailViewModelFactory
import com.example.presentation.viewModel.DetailScreenViewModel
import com.example.screen_detail.R
import com.example.screen_detail.databinding.FragmentDetailScreenBinding
import com.google.android.material.tabs.TabLayoutMediator
import javax.inject.Inject
import kotlin.math.abs

class DetailScreenFragment :
    BaseFragment<FragmentDetailScreenBinding>(R.layout.fragment_detail_screen) {

    override fun initBinding(inflater: LayoutInflater) =
        FragmentDetailScreenBinding.inflate(inflater)

    private val viewModel by viewModels<DetailScreenViewModel> { factory }

    private val listCategory = listOf("Shop", "Details", "Features")

    @Inject
    lateinit var factory: DetailViewModelFactory

    override fun onAttach(context: Context) {
        ViewModelProvider(this).get<DetailComponentViewModel>()
            .newDetailComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isLoading(viewModel.isLoading,binding.progressCircular)

        isErrorInternet(viewModel.errorInternet)

        startAnimation(binding.startAnimation)

        viewModel.getInfo()

        newNavigationClickListener(
            binding.goBack,
            R.id.action_detailScreenFragment_to_mainFragment,
            createExtras(binding.backgroundTransition, TRANSITION_NAME)
        )
        newNavigationClickListener(
            binding.goBasket,
            R.id.action_detailScreenFragment_to_basketScreenFragment2,
            createExtras(binding.backgroundTransition, TRANSITION_NAME)
        )

        carouselBind()

        bindingInfo()
    }

    private fun startAnimation(layout: LinearLayout) {
        layout.animate()
            .alpha(1f)
            .setDuration(700)
            .start()
    }

    private fun carouselBind() {
        binding.viewPagerDetail.apply {
            offscreenPageLimit = 3
            val transformer = CompositePageTransformer()
            transformer.addTransformer(MarginPageTransformer(40))
            transformer.addTransformer { page, position ->
                val r = 1 - abs(position)
                page.scaleY = 0.75f + r * 0.25f
                page.alpha = 0.85f + r * 0.15f
            }
            setPageTransformer(transformer)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bindingInfo() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.isInfo.collect { phone ->
                binding.apply {
                    viewPagerDetail.adapter = DetailAdapter(phone.images)
                    viewPagerInfo.adapter = DetailInfoAdapter(this@DetailScreenFragment, phone)
                    buttonAdd.text = "Add to Card  " + DOLLAR + phone.price.toString()
                    name.text = phone.title
                    ratingBar.rating = phone.rating.toFloat()
                }
                binding.favorite.setOnClickListener {
                    if (phone.isFavorites) {
                        phone.isFavorites = false
                        binding.favorite.setImageResource(R.drawable.ic_favorite_fill)
                    } else {
                        binding.favorite.setImageResource(R.drawable.ic_favorite)
                        phone.isFavorites = true
                    }
                }

                TabLayoutMediator(binding.tableLayoutInfo, binding.viewPagerInfo) { tab, position ->
                    tab.text = listCategory[position]
                }.attach()
            }
        }
    }

}