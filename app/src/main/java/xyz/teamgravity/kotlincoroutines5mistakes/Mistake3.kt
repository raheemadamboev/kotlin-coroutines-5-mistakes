package xyz.teamgravity.kotlincoroutines5mistakes

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

suspend fun doNetworkCall(): Result<String> {
    val result = networkCall()
    return if (result == "Success") Result.success(result)
    else Result.failure(Exception())
}

@Deprecated("Coroutine is not main safe. It can block main thread if executed in main dispatcher coroutine")
suspend fun mistakeNetworkCall(): String {
    delay(3_000L)
    return if (Random.nextBoolean()) "Success" else "Failure"
}

suspend fun networkCall(): String {
    return withContext(Dispatchers.IO) {
        delay(3_000L)
        if (Random.nextBoolean()) "Success" else "Failure"
    }
}