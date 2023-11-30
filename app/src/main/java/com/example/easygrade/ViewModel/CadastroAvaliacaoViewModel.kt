package com.example.easygrade.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.easygrade.Model.Avaliacao;
import com.example.easygrade.Repository.AvaliacaoRepository

class CadastroAvaliacaoViewModel(application: Application) : AndroidViewModel(application) {

    private var txtToast = MutableLiveData<String>()
    private var avaliacaoRepository = AvaliacaoRepository(application.applicationContext)

    fun getTxtToast() : LiveData<String> {
        return txtToast
    }

    fun salvar(nomeAva: String, notaAva: String, pesoAva: String, dataAva: String, counteudosAva: String, idDisciplina: Int, idAvaliacao: Int) : Boolean {
        // Validacoes
        if (validarCampos(nomeAva, "Nome")) {
            return false;
        }

        if(validarCampos(notaAva, "Nota")) {
            return false;
        }

        if(validarCampos(dataAva, "data")) {
            return false;
        }

        if(validarCampos(counteudosAva, "conteudos")) {
            return false;
        }

        if(idDisciplina < 0) {
            txtToast.value = "Erro ao salver avaliaçao";
            return false;
        }

        // Pegando as notas já cadastradas
        val notasAvaliacoes = avaliacaoRepository.getNotasAvaliacoes(idDisciplina);
        val saldoDeNotaParaCadastrar = notasAvaliacoes - 10;

        val notaParaCadastrar = notaAva.toDouble();
        val pesoParaCadastrar = pesoAva.toDouble();

        // Validando o saldo disponivel de nota para cadastro
        if (notaParaCadastrar > saldoDeNotaParaCadastrar) {
            txtToast.value = "A nota não pode ser maior que a média total";
            return false;
        }

        // Validadndo o valor do peso com o valor da nota
        if (pesoParaCadastrar > notaParaCadastrar) {
            txtToast.value = "O peso não pode ser maior que a nota";
            return false;
        }

        // criar objeto do tipo avaliacao
        var avaliacao = Avaliacao(0, nomeAva, notaParaCadastrar, pesoAva.toDouble(), dataAva, counteudosAva, idDisciplina);

        // tentar salvar objeto criado acima
        if (!avaliacaoRepository.salvar(avaliacao)) {
            txtToast.value  = "Erro ao tentar salvar..."
            return false
        }

        txtToast.value = "Salvo com sucesso!";
        return true;
    }

    fun validarCampos(valorDoCampo: String, nomeDoCampo: String): Boolean {
        if(valorDoCampo.isEmpty()) {
            txtToast.value = "Por favor, preencha o campo: '${nomeDoCampo}'";
            return true;
        }

        return  false;
    }
}