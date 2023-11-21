package com.example.easygrade.Repository


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.easygrade.Model.Avaliacao

@Dao
interface AvaliacaoDAO {

    @Insert
    fun salvar(avaliacao: Avaliacao) : Long

    @Delete
    fun deletar(avaliacao: Avaliacao)

    @Update
    fun atualizar(avaliacao: Avaliacao)

    @Query("SELECT * FROM avaliacoes WHERE id = :id")
    fun getAvaliacao(id: Int) : Avaliacao

    @Query("SELECT * FROM avaliacoes")
    fun getAvaliacoes() : List<Avaliacao>

    @Query("SELECT COUNT(*) FROM avaliacoes")
    fun getCountAvaliacoes() : Int

}