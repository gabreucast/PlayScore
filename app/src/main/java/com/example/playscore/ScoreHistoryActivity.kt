package com.example.playscore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.playscore.databinding.ActivityEditNameBinding
import com.example.playscore.databinding.ActivityScoreHistoryBinding

class ScoreHistoryActivity : AppCompatActivity() {

    lateinit var binding: ActivityScoreHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScoreHistoryBinding.inflate(layoutInflater)


        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root){ v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } // ViewCompat

        binding.ivBack.setOnClickListener {
            finish()
        }

    } // onCreate
} // ScoreHistoryActivity : AppCompatActivity()