package com.example.easygrade.View

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easygrade.R

class DisciplinaViewHolder (disciplinaLayout: View) : RecyclerView.ViewHolder(disciplinaLayout) {
    var txtDisciplina = disciplinaLayout.findViewById<TextView>(R.id.txtDisciplina)
    var txtNota = disciplinaLayout.findViewById<TextView>(R.id.txtNota)
}