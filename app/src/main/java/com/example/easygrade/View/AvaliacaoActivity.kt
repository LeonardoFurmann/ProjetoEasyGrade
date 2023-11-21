package com.example.easygrade.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.easygrade.databinding.ActivityAvaliacaoBinding

class AvaliacaoActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityAvaliacaoBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAvaliacaoBinding.inflate(layoutInflater);
        setContentView(binding.root);
    }
}