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

    fun salvar(nomeAva: String, notaAva: Double, pesoAva: Double, dataAva: String, counteudosAva: String, idDisciplina: Int) : Boolean {

        // Todo tafazer validacoes

        // criar objeto do tipo avaliacao
        var avaliacao = Avaliacao(0, nomeAva, notaAva, pesoAva, dataAva, counteudosAva, idDisciplina);

        // tentar salvar objeto criado acima
        if (!avaliacaoRepository.salvar(avaliacao)) {
            txtToast.value  = "Erro ao tentar salvar..."
            return false
        }

        txtToast.value = "Salvo com sucesso!"
        return true
    }
}