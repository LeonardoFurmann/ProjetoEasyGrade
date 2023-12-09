package com.example.easygrade.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.easygrade.R
import com.example.easygrade.ViewModel.CadastroAvaliacaoViewModel
import com.example.easygrade.ViewModel.CadastroDisciplinaViewModel
import com.example.easygrade.databinding.ActivityCadastroDisciplinaBinding


class CadastroDisciplinaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroDisciplinaBinding
    private lateinit var cadastroDisciplinaViewModel: CadastroDisciplinaViewModel
    private var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroDisciplinaBinding.inflate(layoutInflater)

        setContentView(binding.root)

        cadastroDisciplinaViewModel = ViewModelProvider(this).get(CadastroDisciplinaViewModel::class.java)

        setObserver()

        val spinner: Spinner = findViewById(R.id.edtDificuldade)
        ArrayAdapter.createFromResource(
            this,
            R.array.dropdown_items,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        id = intent.getIntExtra("id", 0)

/*        if (id > 0) {
            var temp = cadastroDisciplinaViewModel.getJogador(id)
            binding.txtTitulo.text = "Editar Jogador"
            binding.edtNome.setText(temp.nome)
            binding.edtSexo.setText(temp.sexo)
        }*/

        binding.btnCadastrar.setOnClickListener {
            cadastrarDisciplina();
        }

    }

    private fun cadastrarDisciplina() {

        var nome = binding.edtNome.text.toString();
        var dataIni = binding.edtDtaIni.text.toString();
        var dataFim = binding.edtDtaFim.text.toString();
        var media = binding.edtMedia.text.toString();
        var dificuldade = binding.edtDificuldade.toString();


        var cadastro = cadastroDisciplinaViewModel.salvar(id, nome, dataIni, dataFim, media, dificuldade)

        if (cadastro){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun setObserver() {
        cadastroDisciplinaViewModel.getTxtToast().observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}