package com.example.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Runnable
import kotlin.coroutines.CoroutineContext

interface DispatchersWrapper {
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
    val io: CoroutineDispatcher
}

 class CoroutinesDispatchersWrapper : CoroutineDispatcher() {
     val main = Dispatchers.Main
     val default= Dispatchers.Default
     val io = Dispatchers.IO
     override fun dispatch(context: CoroutineContext, block: Runnable) {

     }

 }