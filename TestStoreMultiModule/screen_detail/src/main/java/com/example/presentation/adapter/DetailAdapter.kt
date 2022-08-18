package com.example.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.screen_detail.databinding.ItemDetailBinding

class DetailAdapter(
    private val detailImage: List<String>
) : RecyclerView.Adapter<DetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DetailViewHolder(
        ItemDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val item = detailImage[position]
        holder.bindInfo(item)
    }

    override fun getItemCount() = detailImage.size
}

