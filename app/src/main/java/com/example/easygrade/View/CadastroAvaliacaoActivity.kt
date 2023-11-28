package com.example.easygrade.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.easygrade.databinding.ActivityCadastroAvaliacaoBinding
import com.example.easygrade.ViewModel.CadastroAvaliacaoViewModel
import androidx.lifecycle.ViewModelProvider

class CadastroAvaliacaoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroAvaliacaoBinding
    private lateinit var cadastroAvaliacaoViewModel: CadastroAvaliacaoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroAvaliacaoBinding.inflate(layoutInflater)
        setContentView(binding.root);

        cadastroAvaliacaoViewModel = ViewModelProvider(this).get(CadastroAvaliacaoViewModel::class.java)
        setObserver();

        // Clicar em salver
        binding.btnCadastrar.setOnClickListener {
            // Pegandos os valores por binding
            val nome = binding.edtNome.text.toString();
            val nota = binding.edtNota.text.toString();
            val peso = binding.edtPeso.text.toString();
            val data = binding.edtData.text.toString();
            val conteudos = binding.edtConteudos.text.toString();
            val idDisciplina = 1; // just for tests
            val idAvaliacao= 0; // just for tests

            cadastroAvaliacaoViewModel.salvar(nome, nota, peso, data, conteudos, idDisciplina, idAvaliacao);
        }
    }

    fun setObserver(){
        cadastroAvaliacaoViewModel.getTxtToast().observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}