package com.example.main_screen.presentation.adapters.hotsales

import com.example.core.dtomodel.mainscreen.nesteddto.HotSaleDto
import com.example.main_screen.databinding.ItemHotSelesBinding
import com.example.main_screen.presentation.adapters.delegates.hotSalesAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder

class HotSalesAdapter : AsyncListDifferDelegationAdapter<HotSaleDto>(DiffUtilHotSale()){

var ViewHolder: AdapterDelegateViewBindingViewHolder<HotSaleDto, ItemHotSelesBinding>?=null

    init {

        delegatesManager.addDelegate(hotSalesAdapterDelegate())
    }


    fun newHolder(){
    }

}

