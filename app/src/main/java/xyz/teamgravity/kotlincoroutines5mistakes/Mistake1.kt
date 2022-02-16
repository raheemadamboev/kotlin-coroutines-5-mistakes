package xyz.teamgravity.kotlincoroutines5mistakes

import kotlinx.coroutines.*

@Deprecated("Not efficient, takes ton of time. It executes network calls sequentially instead they can be executed asynchronously")
suspend fun mistakeGetCarNames(ids: List<Int>): List<String> {
    val names = mutableListOf<String>()
    for (id in ids) {
        names.add(getCarNameById(id))
    }
    return names
}

suspend fun getCarNames(ids: List<Int>): List<String> {
    val names = mutableListOf<Deferred<String>>()
    coroutineScope {
        for (id in ids) {
            val name = async { getCarNameById(id) }
            names.add(name)
        }
    }
    return names.awaitAll()
}

suspend fun getCarNameById(id: Int): String {
    delay(1_000L)
    return "Some car"
}