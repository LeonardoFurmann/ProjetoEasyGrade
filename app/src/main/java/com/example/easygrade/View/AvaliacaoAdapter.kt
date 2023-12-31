package com.example.easygrade.View

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easygrade.R
import com.example.easygrade.Repository.EasyDB

class AvaliacaoAdapter (var context: Context, idDisciplina: Int): RecyclerView.Adapter<AvaliacaoViewHolder>()
{

    val idDisciplinaAux = idDisciplina;
    val dao = EasyDB.getInstance(context).getAvaliacaoDAO()
    var listaAvaliacao = dao.getAvaliacoesPorDisciplina(idDisciplinaAux);

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvaliacaoViewHolder {
        val layoutAvaliacao = LayoutInflater.from(parent.context)
            .inflate(R.layout.avaliacao_layout, parent, false)
        return AvaliacaoViewHolder(layoutAvaliacao)
    }

    override fun onBindViewHolder(holder: AvaliacaoViewHolder, position: Int) {
        val avaliacao = listaAvaliacao[position];
        val idAvaliacao = avaliacao.id;

        if (avaliacao != null) {
            val nota_peso = avaliacao.nota.toString() + "/" + avaliacao.peso.toString();

            holder.txtAvaliacao.text = "${avaliacao.nome} - ${nota_peso}"
            holder.txtDataAvaliacao.text = "${avaliacao.data}"

            holder.txtAvaliacao.setOnLongClickListener {

//           var avaliacao =  dao.getAvaliacao(position + 1);
//           dao.deletar(avaliacao);
//            true

                var intent = Intent(context, CadastroAvaliacaoActivity::class.java)
                intent.putExtra("idAvaliacao", idAvaliacao)
                context.startActivity(intent)
                true
            }
        }
    }
    override fun getItemCount(): Int {
        return listaAvaliacao.size
    }

    fun atualizaAdapter(){
        listaAvaliacao = emptyList()
        listaAvaliacao = dao.getAvaliacoesPorDisciplina(idDisciplinaAux);
        notifyDataSetChanged()
    }
}
