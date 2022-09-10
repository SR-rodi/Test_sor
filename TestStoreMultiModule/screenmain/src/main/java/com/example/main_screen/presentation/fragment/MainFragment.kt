package com.example.main_screen.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.core.fragment.BaseFragment
import com.example.core.tools.TRANSITION_NAME
import com.example.main_screen.R
import com.example.main_screen.databinding.FragmentMainBinding
import com.example.main_screen.presentation.adapters.pager_adapter.CategoryPagerAdapter
import com.example.navigation.createExtras
import com.example.navigation.navigate
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.item_catedory_new.view.*

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun initBinding(inflater: LayoutInflater) = FragmentMainBinding.inflate(inflater)

    private val listCategory = listOf("Phone", "Computer", "Health", "Books", "Person", "Products")
    private val listIcon = listOf(
        R.drawable.ic_phones,
        R.drawable.ic_pc,
        R.drawable.ic_health,
        R.drawable.ic_books,
        R.drawable.ic_profile,
        R.drawable.ic_basket,
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newNavigationClickListener(binding.city,R.id.action_mainFragment_to_mapsFragment)

        newNavigationClickListener(binding.filter, R.id.action_mainFragment_to_filterBottomSheetFragment)

        binding.qr.setOnClickListener {
        }

        binding.pagerCategory.adapter = CategoryPagerAdapter(this) {
            navigate(
                R.id.action_mainFragment_to_detailScreenFragment,
                createExtras(binding.bottomNavigate, TRANSITION_NAME)
            )
        }

        setUpTabLayout()
        // запрещает свайп по ViewPager2
        binding.pagerCategory.isUserInputEnabled = false

        newNavigationClickListener(
            binding.basketButton,
            R.id.action_maineFragment_to_basketFragment,
            createExtras(binding.bottomNavigate, TRANSITION_NAME)
        )
    }

    @SuppressLint("InflateParams")
    private fun setUpTabLayout() {
        TabLayoutMediator(binding.tabLayoutCategory, binding.pagerCategory) { tab, position ->
            tab.text = listCategory[position]
        }.attach()

        listIcon.forEachIndexed { position, image ->
            val imageCategory =
                LayoutInflater.from(requireContext()).inflate(R.layout.item_catedory_new, null)

            imageCategory.image.setImageResource(image)

            binding.tabLayoutCategory.getTabAt(position)?.customView = imageCategory
        }
    }

}

