package com.example.teststoremultimodule.screen

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import com.example.main_screen.R
import com.example.main_screen.presentation.fragment.MainFragment
import com.example.teststoremultimodule.screen.item.ItemBestsellerTest
import com.example.teststoremultimodule.screen.item.ItemHotSalesTest
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.scroll.KScrollView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView


object TestMainScreen : KScreen<TestMainScreen>() {
    override val layoutId: Int = R.layout.fragment_main
    override val viewClass: Class<*> = MainFragment::class.java

    val scrollView = KScrollView { withId(R.id.maine_scroll) }

    val hotSaleRecyclerView = KRecyclerView({ withId(R.id.recycler_vew_hot_sales) },
        itemTypeBuilder = { itemType(::ItemHotSalesTest) })

    val bestSellerRecyclerView = KRecyclerView({ withId(R.id.recycler_best_seller) },
        itemTypeBuilder = { itemType (::ItemBestsellerTest) })

    val basketButton = KButton { withId(R.id.basket_button) }
    val mapButton = KTextView { withId(R.id.city) }
    val filterButton = KButton { withId(R.id.filter) }

    val searchEditText = KEditText { withId(R.id.search) }


    val tabLayout = KTabLayout { withId(R.id.tab_layout_category) }

}

