package xyz.teamgravity.kotlincoroutines5mistakes

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import xyz.teamgravity.kotlincoroutines5mistakes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewmodel by viewModels<Mistake5>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.executeB.setOnClickListener {

//            lifecycleScope.launch {
//                mistake4()
//            }

            mistake5()
        }
    }

    private suspend fun mistake1() {
        println("raheem: started")
        println("raheem: ${getCarNames((1..10).toList())}")
        println("raheem: finished")

        println("raheem: started")
        println("raheem: ${mistakeGetCarNames((1..10).toList())}")
        println("raheem: finished")
    }

    private suspend fun mistake2() {
        //mistakeDoSomething()
        doSomething()
    }

    private suspend fun mistake3() {
        println("raheem: ${doNetworkCall().getOrNull()}")
    }

    private suspend fun mistake4() {
        //mistakeRiskyTask()
        riskyTask()
    }

    private fun mistake5() {
        //lifecycleScope.launch { viewmodel.mistakePostToApi() }
        viewmodel.postToApi()
    }
}