package com.example.teststoremultimodule.screen

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import com.example.main_screen.R
import com.example.main_screen.presentation.fragment.FilterBottomSheetFragment
import io.github.kakaocup.kakao.text.KButton


object TestBottomShitFilter:KScreen<TestBottomShitFilter>() {
    override val layoutId: Int? = R.layout.fragment_filter_bottom_sheet
    override val viewClass: Class<*>?= FilterBottomSheetFragment::class.java

    val buttonGoBack = KButton{withId(R.id.go_back)}
}