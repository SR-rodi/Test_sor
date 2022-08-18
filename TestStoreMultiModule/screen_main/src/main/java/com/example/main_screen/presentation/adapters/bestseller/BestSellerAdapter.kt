package com.example.main_screen.presentation.adapters.bestseller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.main_screen.databinding.ItemBestSellerBinding
import com.example.core.dto.mainscreen.nesteddto.BestSellerDto

class BestSellerAdapter(
    private val clickItem: () -> Unit
) : ListAdapter<BestSellerDto, BestSellerViewHolder>(DiffUtilBestSeller()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BestSellerViewHolder(
        ItemBestSellerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    ) { clickItem() }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}



