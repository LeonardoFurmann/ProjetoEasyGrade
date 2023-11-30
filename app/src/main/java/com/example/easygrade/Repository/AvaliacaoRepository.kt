package com.example.easygrade.Repository

import android.content.Context
import com.example.easygrade.Model.Avaliacao

class AvaliacaoRepository(context: Context) {

    private var dao = EasyDB.getInstance(context).getAvaliacaoDAO()

    fun salvar(avaliacao: Avaliacao) : Boolean {
        return dao.salvar(avaliacao) > 0
    }

    fun deletar (avaliacao: Avaliacao) {
        dao.deletar(avaliacao)
    }

    fun getAvaliacao(id: Int) : Avaliacao {
        return dao.getAvaliacao(id)
    }

    fun getAvaliacoes() : List<Avaliacao> {
        return dao.getAvaliacoes()
    }

    fun getNotasAvaliacoes(id: Int): Int {
        return dao.getNotasAvaliacoes(id);
    }

    fun atualizar(avaliacao: Avaliacao){
        dao.atualizar(avaliacao)
    }

}