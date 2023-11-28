package com.example.easygrade.Repository

import android.content.Context
import com.example.easygrade.Model.Avaliacao
import com.example.easygrade.Model.Disciplina

class DisciplinaRepository(context: Context) {

    private var dao = EasyDB.getInstance(context).getDisciplinaDAO()

    fun salvar(disciplina: Disciplina) : Boolean {
        return dao.salvar(disciplina) > 0
    }

    fun deletar (disciplina: Disciplina) {
        dao.deletar(disciplina)
    }

    fun getDisciplina(id: Int) : Disciplina {
        return dao.getDisciplina(id)
    }

    fun getDisciplinas() : List<Disciplina> {
        return dao.getDisciplinas()
    }

    fun atualizar(disciplina: Disciplina){
        dao.atualizar(disciplina)
    }

}