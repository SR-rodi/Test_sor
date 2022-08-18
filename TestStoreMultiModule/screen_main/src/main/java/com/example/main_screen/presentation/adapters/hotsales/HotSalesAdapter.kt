package com.example.main_screen.presentation.adapters.hotsales

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.main_screen.databinding.ItemHotSelesBinding
import com.example.core.dto.mainscreen.nesteddto.HotSaleDto

class HotSalesAdapter:ListAdapter<HotSaleDto, HotSalesViewHolder>(DiffUtilHotSale()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= HotSalesViewHolder(
        ItemHotSelesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: HotSalesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}