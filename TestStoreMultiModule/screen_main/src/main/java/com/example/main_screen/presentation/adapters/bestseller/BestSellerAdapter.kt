package com.example.main_screen.presentation.adapters.bestseller

import com.example.core.dto.mainscreen.nesteddto.BestSellerDto
import com.example.main_screen.presentation.adapters.delegates.bestSellerAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class BestSellerAdapter (
     clickItem: () -> Unit
) : AsyncListDifferDelegationAdapter<BestSellerDto>(DiffUtilBestSeller()){
    init {
        delegatesManager.addDelegate(bestSellerAdapterDelegate(clickItem))
    }
}