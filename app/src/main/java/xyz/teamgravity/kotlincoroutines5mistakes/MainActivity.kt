package xyz.teamgravity.kotlincoroutines5mistakes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import xyz.teamgravity.kotlincoroutines5mistakes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.executeB.setOnClickListener {
            lifecycleScope.launch {
                mistake1()
            }
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
}