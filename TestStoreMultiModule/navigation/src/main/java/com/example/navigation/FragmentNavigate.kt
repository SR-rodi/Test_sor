package com.example.navigation

import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController


fun Fragment.navigate(actionId: Int, extras: FragmentNavigator.Extras?=null) {
    findNavController().navigate(actionId, null, null,  extras)
}

// создание пары для анимации перехода
fun Fragment.createExtras(view: View, tag: String) = FragmentNavigatorExtras(view to tag)
