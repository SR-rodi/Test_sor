package com.example.basket_screen.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basket_screen.databinding.ItemBasketBinding
import com.example.core.dto.basketscreen.BasketDto

class BasketAdapter(
    private val basketList: List<BasketDto>
) : RecyclerView.Adapter<BasketViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BasketViewHolder(
        ItemBasketBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val item = basketList[position]
        holder.bind(item)
    }

    override fun getItemCount() = basketList.size
}