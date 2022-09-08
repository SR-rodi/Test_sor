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

 class CoroutinesDispatchersWrapper : DispatchersWrapper {
     override val main = Dispatchers.Main
     override val default= Dispatchers.Default
     override val io = Dispatchers.IO


 }