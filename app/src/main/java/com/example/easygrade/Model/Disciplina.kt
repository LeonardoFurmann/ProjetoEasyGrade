package com.example.easygrade.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "disciplinas")
 class Disciplina (
     @PrimaryKey(autoGenerate = true) @ColumnInfo var id: Int,
     @ColumnInfo var nome: String,
     @ColumnInfo var dificuldade: Int,
     @ColumnInfo var dataInicial: Date,
     @ColumnInfo var dataFinal: Date,
     @ColumnInfo var media : Double
 )