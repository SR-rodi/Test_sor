package com.example.main_screen.presentation.adapters.hotsales

import androidx.recyclerview.widget.DiffUtil
import com.example.core.dto.mainscreen.nesteddto.HotSaleDto

class DiffUtilHotSale : DiffUtil.ItemCallback<HotSaleDto>() {

    override fun areItemsTheSame(oldItem: HotSaleDto, newItem: HotSaleDto) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: HotSaleDto, newItem: HotSaleDto) =
        oldItem == newItem
}
