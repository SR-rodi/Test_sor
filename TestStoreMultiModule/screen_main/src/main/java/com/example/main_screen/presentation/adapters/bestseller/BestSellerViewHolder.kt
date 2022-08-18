package com.example.main_screen.presentation.adapters.bestseller

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.core.DOLLAR
import com.example.core.dto.mainscreen.nesteddto.BestSellerDto
import com.example.core.loadingGlide
import com.example.main_screen.R
import com.example.main_screen.databinding.ItemBestSellerBinding


class BestSellerViewHolder(
    private val binding: ItemBestSellerBinding,
    private val clickItem: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.imageView.setOnClickListener { clickItem() }
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: BestSellerDto) =
        binding.apply {
            name.text = item.title
            newPrice.text = DOLLAR + item.discount_price.toString()
            oldPrice.text = DOLLAR + item.price_without_discount.toString()
            imageView.loadingGlide(item.picture)

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



