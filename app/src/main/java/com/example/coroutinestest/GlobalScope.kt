package com.example.coroutinestest

import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun globalScopeTest(){
    val TAG= "globalScope"

    // Lives as long as the application does
    // Gets Cancelled if the Parent Thread finishes before the coroutine

    GlobalScope.launch {
        //Pauses the current coroutine and not the whole thread like Thread.Sleep
        delay(3000L)
        Log.d(TAG, "This is inside the Coroutine Thread's name is ${Thread.currentThread().name}")
    }
    Log.d(TAG, "This is inside the Main Thread Thread's name is ${Thread.currentThread().name}")
}