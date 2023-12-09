package com.example.easygrade.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.easygrade.Model.Disciplina
import com.example.easygrade.Repository.DisciplinaRepository

class CadastroDisciplinaViewModel(application: Application) : AndroidViewModel(application) {

    private var txtToast = MutableLiveData<String>()
    private var disciplinaRepository = DisciplinaRepository(application.applicationContext)

    fun getTxtToast() : LiveData<String> {
        return txtToast
    }

    fun salvar(id : Int, nome: String, dataIni :String, dataFim : String, media : String, dificuldade : String) : Boolean {

        if (nome.isEmpty() ||
            dataIni.isEmpty() ||
            dataFim.isEmpty() ||
            media.isEmpty()
            ) {

            txtToast.value = "Preencha todos os campos!"

            return false
        }

        var mediaNum = media.toDouble()

        if (mediaNum > 10 || mediaNum < 0){
            txtToast.value = "Valor inválido para média"

            return false
        }

        var dificuldadeNum = 0
        if (dificuldade == "Fácil" ){
            dificuldadeNum = 1
        } else if (dificuldade == "Médio") {
            dificuldadeNum = 2
        } else {
            dificuldadeNum = 3
        }

//        if (id > 0){
//            dao.atualizar(jogador)
//            finish()
//            return
//        }


        var disciplina = Disciplina(id,nome, dificuldadeNum, dataIni, dataFim, mediaNum )

        if (!disciplinaRepository.salvar(disciplina)) {
            txtToast.value  = "Erro ao tentar salvar..."
            return false
        }

        txtToast.value = "Salvo com sucesso!"
        return true
    }


    fun diferencaDiasEntreDatasStrings(dataInicio: String, dataFim: String): Long {
        val regex = """(\d{2})/(\d{2})/(\d{4})""".toRegex()
        val matchInicio = regex.find(dataInicio)
        val matchFim = regex.find(dataFim)

        if (matchInicio != null && matchFim != null) {
            val (diaInicio, mesInicio, anoInicio) = matchInicio.destructured
            val (diaFim, mesFim, anoFim) = matchFim.destructured

            val dataInicioEmDias = anoInicio.toLong() * 365 + mesInicio.toLong() * 30 + diaInicio.toLong()
            val dataFimEmDias = anoFim.toLong() * 365 + mesFim.toLong() * 30 + diaFim.toLong()

            return kotlin.math.abs(dataFimEmDias - dataInicioEmDias)
        }

        return -1 // Retorna -1 se houver erro ou dados inválidos
    }
}