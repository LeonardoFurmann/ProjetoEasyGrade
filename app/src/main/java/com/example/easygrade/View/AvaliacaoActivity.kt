package com.example.easygrade.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easygrade.databinding.ActivityAvaliacaoBinding

class AvaliacaoActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityAvaliacaoBinding;
    private lateinit var avalicaoAdapter: AvaliacaoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAvaliacaoBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val idDisciplina = intent.getIntExtra("idDisciplina", -1)
        if (idDisciplina == -1){ finish() }

        val idAvaliacao = intent.getIntExtra("idAvaliacao", -1)



        avalicaoAdapter = AvaliacaoAdapter(this)

        binding.rcvAvaliacoes.layoutManager = LinearLayoutManager(this)
        binding.rcvAvaliacoes.adapter = avalicaoAdapter

        binding.btnAdd.setOnClickListener {
            var intent = Intent(this, CadastroAvaliacaoActivity::class.java);
            intent.putExtra("disciplina", idDisciplina)
            intent.putExtra("idAvaliacao", idAvaliacao)
            this.startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        avalicaoAdapter.atualizaAdapter()
    }
}