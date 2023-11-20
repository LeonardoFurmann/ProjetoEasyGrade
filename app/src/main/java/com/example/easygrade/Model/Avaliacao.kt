package com.example.easygrade.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "avaliacoes" , foreignKeys = [ForeignKey(entity = Disciplina::class, parentColumns = ["id"], childColumns = ["IdDisciplina"],
onDelete = ForeignKey.CASCADE)])
class Avaliacao (
    @PrimaryKey(autoGenerate = true) @ColumnInfo var id: Int,
    @ColumnInfo var nome: String,
    @ColumnInfo var nota: Double,
    @ColumnInfo var peso: Double,
    @ColumnInfo var data: Date,
    @ColumnInfo var conteudos: String,
    @ColumnInfo(name = "IdDisciplina") val IdDisciplina : Int
)