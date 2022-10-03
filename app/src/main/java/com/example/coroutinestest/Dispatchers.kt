package com.example.coroutinestest

import kotlinx.coroutines.*

// https://stackoverflow.com/questions/59039991/difference-between-usage-of-dispatcher-io-and-default  good explanation of all dispatchers


@OptIn(DelicateCoroutinesApi::class)
fun Dispatchers(){

    //Coroutine in the main thread, useful for UI operations, UI changes can be made only through the main thread
    GlobalScope.launch(Dispatchers.Main){

    }
    //IO self-explanatory, used for data operations, networking call, IO to files,
    // IO is an elastic thread pool with a configurable max size. Threads in this pool are expected to spend most of their time in a non-runnable state, awaiting the completion of an IO operation, so it makes sense to have more of them than there are CPU cores.
    GlobalScope.launch(Dispatchers.IO){

    }
    //Complex Long running calculations that may block the main thread, Default has a fixed size hardcoded to the number of available processors, because thats what makes sense for CPU-intensive tasks.
    GlobalScope.launch(Dispatchers.Default){

    }
    /**
     * this coroutine will not be confined to one single thread. If you want to print 1, 2, 3
     * inside an Unconfined coroutine, the sequence might not be the same every time. as multiple
     * thread could execute this single co-routine.
     */
    GlobalScope.launch(Dispatchers.Unconfined){

    }

    //executed in this specific named thread
    GlobalScope.launch(newSingleThreadContext("myThread")) {

    }

}



// Ui needs to be changed through Main thread so you can use withContext to Switch Context
// it can be changed here with IO technically but irl apps that needs to be done on Main
@OptIn(DelicateCoroutinesApi::class)
fun withContextTest(block: (Any?) -> Unit){

    GlobalScope.launch(Dispatchers.IO) {
        val answer = networkCall2()
        withContext(Dispatchers.Main){
            block(answer.toString())
        }
    }

}

suspend fun networkCall2() : String {
    delay(9000L)
    return "This is a network call simulation"
}

// Blocks the thread it is executed in before its own completion
// Can execute other coroutines within it.
fun asdasd() {
    runBlocking {

    }
}