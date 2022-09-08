package com.example.teststoremultimodule.screen.item

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher

class ItemHotSalesTest (parent: Matcher<View>): KRecyclerItem<ItemHotSalesTest>(parent){
    val itemButton = KButton(parent){withText("Buy now!")}
}

