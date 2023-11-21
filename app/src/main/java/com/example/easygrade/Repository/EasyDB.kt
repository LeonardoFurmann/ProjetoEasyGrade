package com.example.easygrade.Repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.easygrade.Model.Avaliacao
import com.example.easygrade.Model.Disciplina

@Database(entities = [Disciplina::class , Avaliacao::class], version = 1)
abstract class EasyDB : RoomDatabase() {

    abstract fun getDisciplinaDAO() : DisciplinaDAO
    abstract fun getAvaliacaoDAO() : AvaliacaoDAO

    companion object {

        private lateinit var INSTANCE : EasyDB

        fun getInstance(context: Context) : EasyDB {

            if (!::INSTANCE.isInitialized){
                INSTANCE = databaseBuilder(context,EasyDB::class.java, "easy_db" )
                    .allowMainThreadQueries()
                    .build()
            }

            return INSTANCE

        }

    }

}