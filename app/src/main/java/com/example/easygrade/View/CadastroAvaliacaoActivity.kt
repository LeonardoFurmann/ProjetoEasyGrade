package com.example.easygrade.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.easygrade.databinding.ActivityCadastroAvaliacaoBinding
class CadastroAvaliacaoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroAvaliacaoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroAvaliacaoBinding.inflate(layoutInflater)

        setContentView(binding.root);
    }
}