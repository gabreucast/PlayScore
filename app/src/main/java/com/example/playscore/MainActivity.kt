package com.example.playscore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
    private var numberBeforeOne = 0
    private var numberBeforeTwo = 0

    private var playerOneName = ""
    private var playerTwoName = ""
    private var gameFinished = false

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

        if (gameFinished) return // Prevents multiple win registrations when both players reach the winning score at same time

        val winnerPlayerOne =
            if (playerOneName.isBlank()) getString(R.string.player_1)
            else playerOneName

        val winnerPlayerTwo =
            if (playerTwoName.isBlank()) getString(R.string.player_2)
            else playerTwoName

        if (playerOne >= 12) {
            gameFinished = true
            showWinner(winnerPlayerOne)
            winsPlayerOne++
        } else if (playerTwo >= 12) {
            gameFinished = true
            showWinner(winnerPlayerTwo)
            winsPlayerTwo++
        }
    }

    private fun showWinner(winner: String) {
        AlertDialog.Builder(this)
            .setTitle("🎉 ${getString(R.string.game_over)} 🎉")
            .setMessage("${getString(R.string.winner_message, winner)} \uD83E\uDD42")
            .setPositiveButton(getString(R.string.restart)) { _, _ ->
                gameFinished = false
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
        fun numberBefore() {
            numberBeforeOne = playerOne
            numberBeforeTwo = playerTwo
        }

        // Number Before
        binding.ivNumberBeforeOne.setOnClickListener {
            // if (numberBeforeOne != 0) {
            playerOne = numberBeforeOne
            updateScreen()
            // }
        }

        // Number Before
        binding.ivNumberBeforeTwo.setOnClickListener {
            playerTwo = numberBeforeTwo
            updateScreen()
        }

        binding.tvPlayerOne.setOnLongClickListener {
            Toast.makeText(
                this,
                getString(R.string.edit_player_name),
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        binding.tvPlayerTwo.setOnLongClickListener {
            Toast.makeText(
                this,
                getString(R.string.edit_player_name),
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        binding.btHistory.setOnLongClickListener {
            Toast.makeText(
                this,
                getString(R.string.show_score_history),
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        binding.btClear.setOnLongClickListener {
            Toast.makeText(
                this,
                getString(R.string.clear_points),
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        binding.ivNumberBeforeOne.setOnLongClickListener {
            Toast.makeText(
                this,
                getString(R.string.undo),
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        binding.ivNumberBeforeTwo.setOnLongClickListener {
            Toast.makeText(
                this,
                getString(R.string.undo),
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        binding.ivEdit1.setOnLongClickListener {
            Toast.makeText(
                this,
                getString(R.string.edit_player_name),
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        binding.ivEdit2.setOnLongClickListener {
            Toast.makeText(
                this,
                getString(R.string.edit_player_name),
                Toast.LENGTH_SHORT
            ).show()
            true
        }

        // Score History Button
        binding.btHistory.setOnClickListener {
            val intent = Intent(this, ScoreHistoryActivity::class.java)
            intent.putExtra("winsPlayerOne", winsPlayerOne)
            intent.putExtra("winsPlayerTwo", winsPlayerTwo)
            intent.putExtra("playerOneName", playerOneName)
            intent.putExtra("playerTwoName", playerTwoName)
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
            numberBefore()
            playerOne += 1
            updateScreen()
        }

        binding.btAddThree1.setOnClickListener {
            numberBefore()
            playerOne += 3
            updateScreen()
        }

        binding.btAddSix1.setOnClickListener {
            numberBefore()
            playerOne += 6
            updateScreen()
        }

        binding.btAddNine1.setOnClickListener {
            numberBefore()
            playerOne += 9
            updateScreen()
        }

        binding.btAddTwelve1.setOnClickListener {
            numberBefore()
            playerOne += 12
            updateScreen()
        }

        // Player 2
        binding.btAddOne2.setOnClickListener {
            numberBefore()
            playerTwo += 1
            updateScreen()
        }

        binding.btAddThree2.setOnClickListener {
            numberBefore()
            playerTwo += 3
            updateScreen()
        }

        binding.btAddSix2.setOnClickListener {
            numberBefore()
            playerTwo += 6
            updateScreen()
        }

        binding.btAddNine2.setOnClickListener {
            numberBefore()
            playerTwo += 9
            updateScreen()
        }

        binding.btAddTwelve2.setOnClickListener {
            numberBefore()
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

