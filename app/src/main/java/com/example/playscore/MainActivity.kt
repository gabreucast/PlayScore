package com.example.playscore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.playscore.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var playerOne = 0
    private var playerTwo = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupClickListeners()
        updateScreen()

    } //onCreate

    private fun checkWinner(){
        if (playerOne >= 12) showWinner(getString(R.string.player_1))
        else if (playerTwo >= 12) showWinner(getString(R.string.player_2))
    }
    private fun showWinner(winner: String) {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.game_over))
            .setMessage(getString(R.string.winner_message, winner))
            .setPositiveButton(getString(R.string.restart)) { _, _ ->
                playerOne = 0
                playerTwo = 0
                updateScreen()
            }
            .setCancelable(false)
            .show()
    }

    fun updateScreen() {
        binding.tvPointsOne.text = String.format("%02d", playerOne)
        binding.tvPointsTwo.text = String.format("%02d", playerTwo)
        checkWinner()
    } //updateScreen()

    private fun setupClickListeners() {

        // Player 1
        binding.btAddOne1.setOnClickListener {
            playerOne += 1
            updateScreen()
        }

        binding.btAddThree1.setOnClickListener {
            playerOne += 3
            updateScreen()
        }

        binding.btAddSix1.setOnClickListener {
            playerOne += 6
            updateScreen()
        }

        binding.btAddNine1.setOnClickListener {
            playerOne += 9
            updateScreen()
        }

        binding.btAddTwelve1.setOnClickListener {
            playerOne += 12
            updateScreen()
        }

        // Player 2
        binding.btAddOne2.setOnClickListener {
            playerTwo += 1
            updateScreen()
        }

        binding.btAddThree2.setOnClickListener {
            playerTwo += 3
            updateScreen()
        }

        binding.btAddSix2.setOnClickListener {
            playerTwo += 6
            updateScreen()
        }

        binding.btAddNine2.setOnClickListener {
            playerTwo += 9
            updateScreen()
        }

        binding.btAddTwelve2.setOnClickListener {
            playerTwo += 12
            updateScreen()
        }
    } // setupClickListeners()



} // MainActivity : AppCompatActivity()

//https://drive.google.com/file/d/1IIUbG7GQOrjMY8Ml83UyKp98QqttvNib/view?pli=1
