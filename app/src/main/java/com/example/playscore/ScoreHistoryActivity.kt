package com.example.playscore

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.playscore.databinding.ActivityScoreHistoryBinding

class ScoreHistoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityScoreHistoryBinding
    private var winsPlayerOne = 0
    private var winsPlayerTwo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScoreHistoryBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                saveAndExit()
            }

        })

        if (savedInstanceState != null) {
            winsPlayerOne = savedInstanceState.getInt("winsPlayerOne")
            winsPlayerTwo = savedInstanceState.getInt("winsPlayerTwo")
        } else {
            winsPlayerOne = intent.getIntExtra("winsPlayerOne", 0)
            winsPlayerTwo = intent.getIntExtra("winsPlayerTwo", 0)
        }
        showWins()

        binding.ivBack.setOnClickListener {
            saveAndExit()
        }

        binding.btClearHistory.setOnClickListener {
            winsPlayerOne = 0
            winsPlayerTwo = 0

            showWins()
        } // btClearHistory Listener
    } // onCreate

    private fun saveAndExit() {
        val resultIntent = Intent()

        resultIntent.putExtra("winsPlayerOne", winsPlayerOne)
        resultIntent.putExtra("winsPlayerTwo", winsPlayerTwo)

        setResult(RESULT_OK, resultIntent)

        finish()
    }
    private fun showWins() {
        binding.etVictoriesOne.text = winsPlayerOne.toString()
        binding.etVictoriesTwo.text = winsPlayerTwo.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("winsPlayerOne", winsPlayerOne)
        outState.putInt("winsPlayerTwo", winsPlayerTwo)
    }
} // ScoreHistoryActivity : AppCompatActivity()