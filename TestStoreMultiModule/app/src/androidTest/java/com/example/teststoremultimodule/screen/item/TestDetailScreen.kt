package com.example.teststoremultimodule.screen.item

import com.example.basket_screen.presentation.fragment.BasketScreenFragment
import com.example.presentation.fragment.DetailScreenFragment
import com.kaspersky.kaspresso.screens.KScreen

import com.example.screen_detail.R

import io.github.kakaocup.kakao.text.KButton


object TestDetailScreen : KScreen<TestDetailScreen>() {
    override val layoutId: Int = R.layout.fragment_detail_screen
    override val viewClass: Class<*> = DetailScreenFragment::class.java

    val goBackButton = KButton { withId(R.id.go_back) }

}
