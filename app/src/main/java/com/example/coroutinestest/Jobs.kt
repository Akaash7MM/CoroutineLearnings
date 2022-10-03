package com.example.coroutinestest

import android.util.Log
import kotlinx.coroutines.*
// .join joins with the containing Thread
// .cancel cancels the job if possible, otherwise use isActive to check if the job is in Cancelled state or active
// withTimeout(L) job cancelled after timeout
@OptIn(DelicateCoroutinesApi::class)
fun JobsJoined(){

    val TAG = "Jobs123"
    val job = GlobalScope.launch(Dispatchers.Default){
          repeat(5){
              Log.d(TAG,"Coroutine running")
          }
    }

    runBlocking {
        job.join()
        Log.d(TAG,"Main Thread is running now")
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun JobsCancelled(){

    val TAG = "Jobs123"
    val job = GlobalScope.launch(Dispatchers.Default){
        repeat(5){
            Log.d(TAG,"Coroutine running")
            delay(1000L)
        }
    }

    runBlocking {
        delay(2000L)
        job.cancel()
        Log.d(TAG,"Main Thread is running now")
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun JobsHeavy(){
    val TAG = "Jobs123"
    val job = GlobalScope.launch(Dispatchers.Default){
        Log.d(TAG,"Starting Calculation")
        withTimeout(2000L){
            for (i in 30..40){
                if(isActive){
                    Log.d(TAG,"Result for $i is ${fib(i)}")
                }
            }
        }

        Log.d(TAG,"Ending Calculations")
    }

    runBlocking {
        delay(2000L)
        job.cancel()
        Log.d(TAG,"Job Cancelled Main thread is running now")
    }
}

fun fib(number:Int) : Long{
    return if(number==0)0
    else if(number==1) 1
    else fib(number -1)+fib(number-2)
}