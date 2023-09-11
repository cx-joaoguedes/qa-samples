package dosbysleep

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import java.util.concurrent.TimeUnit

class Main {

    fun main(args : Array<String>) {
        var userInput = args[0].toLong()

        unsafe1(userInput)
        unsafe2(userInput)
        unsafe3(userInput)
        unsafe4(userInput)
        safe1(userInput)
        safe2(userInput)
        safe3(userInput)
    }

    fun unsafe1(input : Long) = Thread.sleep(input)
    fun unsafe2(input : Long) = TimeUnit.SECONDS.sleep(input)
    fun unsafe3(input : Long) = runBlocking { launch { delay(input) } }
    fun unsafe4(input : Long) = runBlocking { repeat(input.toInt()) { delay(1000) } }

    fun safe1(input: Long) {
        runBlocking {
            launch {
                val MAX_TIME : Long = 1000
                val timeSafe : Long = if(input > MAX_TIME) MAX_TIME else input
                delay(timeSafe)
            }
        }
    }

    fun safe2(input: Long) = runBlocking { withTimeout(1300L) { repeat(1000) { delay(input) } } }

    fun safe3(input: Long) {
        runBlocking {
            val job = launch { repeat(1000) { delay(input) } }
            delay(1500)
            job.cancel()
            job.join()
        }
    }
}