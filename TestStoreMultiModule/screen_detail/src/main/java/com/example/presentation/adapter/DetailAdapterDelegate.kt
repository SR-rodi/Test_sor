package com.example.presentation.adapter

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import com.example.core.DOLLAR
import com.example.core.dto.basketscreen.BasketDto
import com.example.core.loadingGlide
import com.example.screen_detail.databinding.ItemDetailBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

class DetailAdapterDelegate(detailImage: List<String>) :
    ListDelegationAdapter<List<String>>() {

    init {
        delegatesManager.addDelegate(detailAdapterDelegate())
        setItems(detailImage)
    }

    @SuppressLint("SetTextI18n")
    fun detailAdapterDelegate() =
        adapterDelegateViewBinding<String, String, ItemDetailBinding>(
            { layoutInflater, root -> ItemDetailBinding.inflate(layoutInflater, root, false) }
        ) {
            bind {
                Glide.with(binding.root)
                    .load(item)
                    .into(binding.detailImage)
            }
        }
}
