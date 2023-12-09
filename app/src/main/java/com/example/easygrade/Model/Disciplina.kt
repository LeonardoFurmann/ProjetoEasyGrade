package com.example.easygrade.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "disciplinas")
 class Disciplina (
     @PrimaryKey(autoGenerate = true) @ColumnInfo var id: Int,
     @ColumnInfo var nome: String,
     @ColumnInfo var dificuldade: Int,
     @ColumnInfo var dataInicial: String,
     @ColumnInfo var dataFinal: String,
     @ColumnInfo var media : Double
 )