package com.luanabarbosa.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.luanabarbosa.cards.databinding.NavActivityBinding

class StartActivity : AppCompatActivity() {
    lateinit var binding: NavActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NavActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
