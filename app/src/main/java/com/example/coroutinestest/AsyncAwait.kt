package com.example.coroutinestest

import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//these two calls are being made asyncrously that is executed concurrently to each other/maybe parrallel depends
// await waits for the value , the value type is deffered
// incase the values depend on each other, then use normal jobs and dont use async
@OptIn(DelicateCoroutinesApi::class)
fun AsyncAwait(){
    val TAG = "Async"

    GlobalScope.launch(Dispatchers.IO){
       val time = measureTimeMillis {
           val first = async { networkCall1() }
           val second = async { networkCall3() }

           Log.d(TAG,"The value is ${first.await()}")
           Log.d(TAG,"The value is ${second.await()}")
       }
        Log.d(TAG,"time is $time ms")

    }
    }


suspend fun networkCall1() : String {
    delay(3000L)
    return "This is a network call simulation"
}

suspend fun networkCall3() : String {
    delay(3000L)
    return "This is a network call simulation"
}