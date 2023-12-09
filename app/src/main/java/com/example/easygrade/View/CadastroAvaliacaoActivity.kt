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
    private var idAvaliacao = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroAvaliacaoBinding.inflate(layoutInflater)
        setContentView(binding.root);

        cadastroAvaliacaoViewModel = ViewModelProvider(this).get(CadastroAvaliacaoViewModel::class.java)
        setObserver();

        var disciplina = intent.getIntExtra("disciplina", -1)
        if (disciplina == -1){ finish() }

         idAvaliacao = intent.getIntExtra("idAvaliacao", -1)

        /*
            if (id > 0) {
             var temp = cadastroDisciplinaViewModel.getJogador(id)
             binding.txtTitulo.text = "Editar Jogador"
             binding.edtNome.setText(temp.nome)
              binding.edtSexo.setText(temp.sexo)
           }*/

        // Clicar em salver
        binding.btnCadastrar.setOnClickListener {
            // Pegandos os valores por binding
            val nome = binding.edtNome.text.toString();
            val nota = binding.edtNota.text.toString();
            val peso = binding.edtPeso.text.toString();
            val data = binding.edtData.text.toString();
            val conteudos = binding.edtConteudos.text.toString();
            val idDisciplina = disciplina;
            val idAvaliacao= idAvaliacao;

            if (cadastroAvaliacaoViewModel.salvar(nome, nota, peso, data, conteudos, idDisciplina, idAvaliacao)) {
                finish();
            }
        }
    }

    fun setObserver(){
        cadastroAvaliacaoViewModel.getTxtToast().observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}