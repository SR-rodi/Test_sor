package com.example.main_screen.presentation.adapters.bestseller

import androidx.recyclerview.widget.DiffUtil
import com.example.core.dtomodel.mainscreen.nesteddto.BestSellerDto

class DiffUtilBestSeller : DiffUtil.ItemCallback<BestSellerDto>() {

    override fun areItemsTheSame(oldItem: BestSellerDto, newItem: BestSellerDto) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: BestSellerDto, newItem: BestSellerDto): Boolean =
        oldItem == newItem

}