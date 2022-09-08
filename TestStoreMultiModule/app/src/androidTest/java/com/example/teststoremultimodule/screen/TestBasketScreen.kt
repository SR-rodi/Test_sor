package com.example.teststoremultimodule.screen

import com.example.basket_screen.presentation.fragment.BasketScreenFragment
import com.kaspersky.kaspresso.screens.KScreen

import com.example.basket_screen.R

import io.github.kakaocup.kakao.text.KButton


object TestBasketScreen:KScreen<TestBasketScreen>() {
    override val layoutId: Int = R.layout.fragment_basket_screen
    override val viewClass: Class<*> =BasketScreenFragment::class.java

    val goBackButton = KButton { withId(R.id.go_back) }

}
