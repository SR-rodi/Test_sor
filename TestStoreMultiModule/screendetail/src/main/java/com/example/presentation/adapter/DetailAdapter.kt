package com.example.presentation.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class DetailAdapter(detailImage: List<String>) :
    ListDelegationAdapter<List<String>>() {

    init {
        delegatesManager.addDelegate(detailAdapterDelegate())
        setItems(detailImage)
    }
}
