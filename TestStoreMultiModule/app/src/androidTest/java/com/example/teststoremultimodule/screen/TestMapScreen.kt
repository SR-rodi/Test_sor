package com.example.teststoremultimodule.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.example.screenmap.R
import com.example.screenmap.presentation.MapsFragment
import io.github.kakaocup.kakao.common.views.KView

object TestMapScreen:KScreen<TestMapScreen>() {
    override val layoutId: Int? =R.layout.fragment_maps
    override val viewClass: Class<*>? = MapsFragment::class.java

    val map = KView{R.id.map}
}