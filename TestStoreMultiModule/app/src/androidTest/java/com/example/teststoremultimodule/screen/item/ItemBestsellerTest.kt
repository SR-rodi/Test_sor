package com.example.teststoremultimodule.screen.item

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import com.example.main_screen.R
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher

class ItemBestsellerTest(parent: Matcher<View>): KRecyclerItem<ItemHotSalesTest>(parent){
    val itemImageButton = KButton(parent){withId(R.id.imageView_bestSeller)}
    val itemFavorite = KButton(parent){withId(R.id.favorite)}
}