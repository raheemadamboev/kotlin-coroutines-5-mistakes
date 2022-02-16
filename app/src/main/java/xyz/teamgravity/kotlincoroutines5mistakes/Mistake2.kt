package xyz.teamgravity.kotlincoroutines5mistakes

import kotlinx.coroutines.*
import kotlin.random.Random

@Deprecated("even though we cancel coroutine")
suspend fun mistakeDoSomething() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        var random = Random.nextInt(100_000)
        while (random != 50_000) {
            println("raheem: $random")
            random = Random.nextInt(100_000)
        }
    }
    println("daheem: our job cancelled")
    delay(500L)
    job.cancel()
}

suspend fun doSomething() {
    val job = CoroutineScope(Dispatchers.Default).launch {
        var random = Random.nextInt(100_000)
        while (random != 50_000) {
            ensureActive()
            println("raheem: $random")
            random = Random.nextInt(100_000)
        }
    }
    println("daheem: our job cancelled")
    delay(500L)
    job.cancel()
}