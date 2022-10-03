package com.example.coroutinestest

import android.util.Log
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//Suspend keyword helps us mark a function as suspendable, and can only be run in a coroutine context.
// This can be important as a function may need to carry out a heavy task that may block the UI and using suspend we tell to only to run in cooroutine

// Also nested functions can only be accessed by the code written after them

@OptIn(DelicateCoroutinesApi::class)
fun suspendFuctions(){

    val TAG= "suspend"

    suspend fun networkCall1() : String {
        delay(3000L)
        return "This is a network call simulation"
    }
    suspend fun networkCall2() : String {
        delay(3000L)
        return "This is a network call simulation"
    }

    // variables get assigned 3 secs each and its takes 3+3 to print out the log
    GlobalScope.launch {
        val answer1 = networkCall1()
        val answer2 = networkCall2()
        Log.d(TAG,answer1)
        Log.d(TAG,answer2)
    }
}