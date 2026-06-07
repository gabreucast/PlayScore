package com.example.playscore

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.playscore.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var playerOne = 0
    private var playerTwo = 0
    private var winsPlayerOne = 0
    private var winsPlayerTwo = 0

    private var playerOneName = ""
    private var playerTwoName = ""

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

        if (savedInstanceState != null) {
            playerOne = savedInstanceState.getInt("playerOne")
            playerTwo = savedInstanceState.getInt("playerTwo")
            winsPlayerOne = savedInstanceState.getInt("winsPlayerOne")
            winsPlayerTwo = savedInstanceState.getInt("winsPlayerTwo")
            playerOneName = savedInstanceState.getString("playerOneName", "")
            playerTwoName = savedInstanceState.getString("playerTwoName", "")
        } else {
            winsPlayerOne = intent.getIntExtra("winsPlayerOne", 0)
            winsPlayerTwo = intent.getIntExtra("winsPlayerTwo", 0)
        }

        setupClickListeners()
        updateScreen()

    } //onCreate

    private val getResults = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { retorno ->

        if (retorno.resultCode == RESULT_OK) {

            winsPlayerOne =
                retorno.data?.getIntExtra("winsPlayerOne", winsPlayerOne) ?: winsPlayerOne

            winsPlayerTwo =
                retorno.data?.getIntExtra("winsPlayerTwo", winsPlayerTwo) ?: winsPlayerTwo

            playerOneName =
                retorno.data?.getStringExtra("playerOneName") ?: playerOneName

            playerTwoName =
                retorno.data?.getStringExtra("playerTwoName") ?: playerTwoName
        }
        updateScreen()
    }

    private fun checkWinner() {
        if (playerOne >= 12) {
            showWinner(getString(R.string.player_1))
            winsPlayerOne++
        } else if (playerTwo >= 12) {
            showWinner(getString(R.string.player_2))
            winsPlayerTwo++
        }
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

        binding.tvPlayerOne.text =
            if (playerOneName.isBlank()) getString(R.string.player_1)
            else playerOneName

        binding.tvPlayerTwo.text =
            if (playerTwoName.isBlank()) getString(R.string.player_2)
            else playerTwoName

        checkWinner()
    } // updateScreen()

    private fun setupClickListeners() {

        // Score History Button
        binding.btHistory.setOnClickListener {
            val intent = Intent(this, ScoreHistoryActivity::class.java)
            intent.putExtra("winsPlayerOne", winsPlayerOne)
            intent.putExtra("winsPlayerTwo", winsPlayerTwo)
            getResults.launch(intent)
        }

        // Clean Points Button
        binding.btClear.setOnClickListener {
            playerOne = 0
            playerTwo = 0
            updateScreen()
        }

        // EditPlayer1
        binding.tvPlayerOne.setOnClickListener {
            val intent = Intent(this, EditName::class.java)
            intent.putExtra("playerOneName", playerOneName)
            intent.putExtra("playerTwoName", playerTwoName)
            getResults.launch(intent)
        }

        // EditPlayer2
        binding.tvPlayerTwo.setOnClickListener {
            val intent = Intent(this, EditName::class.java)
            intent.putExtra("playerOneName", playerOneName)
            intent.putExtra("playerTwoName", playerTwoName)
            getResults.launch(intent)
        }

        // EditPlayer2
        binding.ivEdit2.setOnClickListener {
            val intent = Intent(this, EditName::class.java)
            intent.putExtra("playerOneName", playerOneName)
            intent.putExtra("playerTwoName", playerTwoName)
            getResults.launch(intent)
        }

        // EditPlayer1
        binding.ivEdit1.setOnClickListener {
            val intent = Intent(this, EditName::class.java)
            intent.putExtra("playerOneName", playerOneName)
            intent.putExtra("playerTwoName", playerTwoName)
            getResults.launch(intent)
        }

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("playerOne", playerOne)
        outState.putInt("playerTwo", playerTwo)
        outState.putInt("winsPlayerOne", winsPlayerOne)
        outState.putInt("winsPlayerTwo", winsPlayerTwo)
        outState.putString("playerOneName", playerOneName)
        outState.putString("playerTwoName", playerTwoName)

    }

} // MainActivity : AppCompatActivity()

