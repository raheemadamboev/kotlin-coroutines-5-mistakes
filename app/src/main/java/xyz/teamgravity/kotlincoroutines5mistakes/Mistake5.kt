package xyz.teamgravity.kotlincoroutines5mistakes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Mistake5 : ViewModel() {

    @Deprecated("it is executed in activities lifecycle scope, if config changes post result gets canceled")
    suspend fun mistakePostToApi() {
        delay(10_000L)
        println("raheem: Success")
    }

    fun postToApi() {
        viewModelScope.launch {
            delay(10_000L)
            println("raheem: Success")
        }
    }
}