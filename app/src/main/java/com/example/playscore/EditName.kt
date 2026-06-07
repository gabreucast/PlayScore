package com.example.playscore

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.playscore.databinding.ActivityEditNameBinding

class EditName : AppCompatActivity() {
    lateinit var binding: ActivityEditNameBinding
    private var playerOneName = ""
    private var playerTwoName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditNameBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    finish()
                }

            })

        if (savedInstanceState != null) {
            playerOneName = savedInstanceState.getString("playerOneName", "")
            playerTwoName = savedInstanceState.getString("playerTwoName", "")
        } else {

            playerOneName = intent.getStringExtra("playerOneName") ?: ""
            playerTwoName = intent.getStringExtra("playerTwoName") ?: ""
        }

        if (playerOneName.isNotBlank()) {
            binding.tilPlayerOne.editText?.setText(playerOneName)
        }

        if (playerTwoName.isNotBlank()) {
            binding.tilPlayerTwo.editText?.setText(playerTwoName)
        }

        binding.btStartGame.setOnClickListener {
            playerOneName = binding.tilPlayerOne.editText?.text.toString()
            playerTwoName = binding.tilPlayerTwo.editText?.text.toString()
            saveAndExit()
        }

        binding.ivBack.setOnClickListener {
            finish()
        }

        binding.btStartGame.setOnLongClickListener {
            Toast.makeText(
                this,
                getString(R.string.confirm),
                Toast.LENGTH_SHORT
            ).show()
            true
        }

    } // onCreate()

    private fun saveAndExit() {
        playerOneName = binding.tilPlayerOne.editText?.text.toString()
        playerTwoName = binding.tilPlayerTwo.editText?.text.toString()

        val resultIntent = Intent()

        resultIntent.putExtra("playerOneName", playerOneName)
        resultIntent.putExtra("playerTwoName", playerTwoName)

        setResult(RESULT_OK, resultIntent)

        finish()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("playerOneName", binding.tilPlayerOne.editText?.text.toString())
        outState.putString("playerTwoName", binding.tilPlayerTwo.editText?.text.toString())
    }

} // EditName : AppCompatActivity()