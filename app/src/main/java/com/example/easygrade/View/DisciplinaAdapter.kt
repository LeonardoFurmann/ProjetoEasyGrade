package com.example.easygrade.View

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easygrade.R
import com.example.easygrade.Repository.EasyDB

class DisciplinaAdapter (var context: Context): RecyclerView.Adapter<DisciplinaViewHolder>()
{

    val dao = EasyDB.getInstance(context).getDisciplinaDAO()
    var listaDisciplina = dao.getDisciplinas()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisciplinaViewHolder {
        val layoutDisciplina = LayoutInflater.from(parent.context)
            .inflate(R.layout.disciplina_layout, parent, false)
        return DisciplinaViewHolder(layoutDisciplina)
    }

    override fun onBindViewHolder(holder: DisciplinaViewHolder, position: Int) {

        val disciplina = dao.getDisciplina(position + 1);

        val fakeNota = 7; // todo calcular a nota somando todos as notas das avaliacoes

        //val nota_peso = disciplina.nota.toString() + "/" + disciplina.peso.toString();

        holder.txtDisciplina.text = "${disciplina.nome} ";
        holder.txtNota.text = "${fakeNota}/10";

//        holder.txtDisciplina.setOnClickListener {
//            var intent = Intent(context, AvaliacaoActivity::class.java)
//            //intent.putExtra("position", position)
//            context.startActivity(intent)
//            true
//        }

        holder.txtDisciplina.setOnClickListener {
            var intent = Intent(context, AvaliacaoActivity::class.java)
            intent.putExtra("idDisciplina", position + 1)
            context.startActivity(intent)
            true
        }

    }
    override fun getItemCount(): Int {
        return listaDisciplina.size
    }

    fun atualizaAdapter(){
        listaDisciplina = emptyList()
        listaDisciplina = dao.getDisciplinas()
        notifyDataSetChanged()
    }

}
