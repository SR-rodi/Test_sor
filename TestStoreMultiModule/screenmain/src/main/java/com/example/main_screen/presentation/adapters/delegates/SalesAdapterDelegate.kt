package com.example.main_screen.presentation.adapters.delegates

import android.annotation.SuppressLint
import com.example.core.tools.DOLLAR
import com.example.core.dtomodel.mainscreen.nesteddto.BestSellerDto
import com.example.core.dtomodel.mainscreen.nesteddto.HotSaleDto
import com.example.core.tools.loadingGlide

import com.example.main_screen.R
import com.example.main_screen.databinding.ItemBestSellerBinding
import com.example.main_screen.databinding.ItemHotSelesBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun hotSalesAdapterDelegate() =
    adapterDelegateViewBinding<HotSaleDto, HotSaleDto, ItemHotSelesBinding>(
        { layoutInflater, root -> ItemHotSelesBinding.inflate(layoutInflater, root, false) }
    ) {
        bind {
            binding.apply {
                if (item.is_new) newLabel.alpha = 1f
                else newLabel.alpha = 0f
                title.text = item.title
                subtitle.text = item.subtitle
                imageView2.loadingGlide(item.picture)
            }
        }
    }


@SuppressLint("SetTextI18n")
fun bestSellerAdapterDelegate(
    clickItem: () -> Unit
) =
    adapterDelegateViewBinding<BestSellerDto, BestSellerDto, ItemBestSellerBinding>(
        { layoutInflater, root -> ItemBestSellerBinding.inflate(layoutInflater, root, false) }
    ) {

        binding.imageViewBestSeller.setOnClickListener {
            clickItem()
        }

        bind {
            binding.apply {
                name.text = item.title
                newPrice.text = DOLLAR + item.discount_price.toString()
                oldPrice.text = DOLLAR + item.price_without_discount.toString()
                imageViewBestSeller.loadingGlide(item.picture)

                if (item.is_favorites) favorite.setImageResource(R.drawable.ic_favorite_)
                else favorite.setImageResource(R.drawable.ic_frame_favorite)

                binding.favorite.setOnClickListener {
                    if (item.is_favorites) {
                        item.is_favorites = false
                        favorite.setImageResource(R.drawable.ic_frame_favorite)
                    } else {
                        item.is_favorites = true
                        favorite.setImageResource(R.drawable.ic_favorite_)
                    }
                }
            }

        }
    }