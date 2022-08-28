package com.example.main_screen.presentation.adapters.hotsales

import com.example.core.dtomodel.mainscreen.nesteddto.HotSaleDto
import com.example.main_screen.presentation.adapters.delegates.hotSalesAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class HotSalesAdapter : AsyncListDifferDelegationAdapter<HotSaleDto>(DiffUtilHotSale()){
    init {
        delegatesManager.addDelegate(hotSalesAdapterDelegate())
    }
}

