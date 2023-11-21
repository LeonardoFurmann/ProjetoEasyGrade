package com.example.easygrade.Repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.easygrade.Model.Disciplina

@Dao
interface DisciplinaDAO {

    @Insert
    fun salvar(disciplina: Disciplina) : Long

    @Delete
    fun deletar(disciplina: Disciplina)

    @Update
    fun atualizar(disciplina: Disciplina)

    @Query("SELECT * FROM disciplinas WHERE id = :id")
    fun getDisciplina(id: Int) : Disciplina

    @Query("SELECT * FROM disciplinas")
    fun getDisciplinas() : List<Disciplina>
}