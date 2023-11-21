package com.example.easygrade.View

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easygrade.R

class AvaliacaoViewHolder (avaliacaoLayout: View) : RecyclerView.ViewHolder(avaliacaoLayout) {
    var txtAvaliacao = avaliacaoLayout.findViewById<TextView>(R.id.txtAvaliacao)
    var txtDataAvaliacao = avaliacaoLayout.findViewById<TextView>(R.id.txtDataAvaliacao)
}