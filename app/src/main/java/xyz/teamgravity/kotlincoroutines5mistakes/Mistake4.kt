package xyz.teamgravity.kotlincoroutines5mistakes

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay

@Deprecated("it even catches CancelationException which parent coroutine must know")
suspend fun mistakeRiskyTask() {
    try {
        delay(3_000L)
        val error = 10 / 0
    } catch (e: Exception) {
        println("raheem: fucked up")
    }
}

suspend fun riskyTask() {
    try {
        delay(3_000L)
        val error = 10 / 0
    } catch (e: Exception) {
        if (e is CancellationException) throw e
        println("raheem: fucked up")
    }
}