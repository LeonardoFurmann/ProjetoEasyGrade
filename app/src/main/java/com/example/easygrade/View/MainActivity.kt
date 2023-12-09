package com.example.easygrade.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easygrade.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var disciplinaAdapter: DisciplinaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        disciplinaAdapter = DisciplinaAdapter(this)

        binding.rcvDisciplinas.layoutManager = LinearLayoutManager(this)
        binding.rcvDisciplinas.adapter = disciplinaAdapter

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, CadastroDisciplinaActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        disciplinaAdapter.atualizaAdapter()
    }
}