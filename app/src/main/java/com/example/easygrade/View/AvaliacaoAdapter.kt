package com.example.easygrade.View

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easygrade.R
import com.example.easygrade.Repository.EasyDB

class AvaliacaoAdapter (var context: Context): RecyclerView.Adapter<AvaliacaoViewHolder>()
{

    val dao = EasyDB.getInstance(context).getAvaliacaoDAO()
    val listaAvaliacao = dao.getAvaliacoes()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AvaliacaoViewHolder {
        val layoutCarro = LayoutInflater.from(parent.context)
            .inflate(R.layout.avaliacao_layout, parent, false)
        return AvaliacaoViewHolder(layoutCarro)
    }

    override fun onBindViewHolder(holder: AvaliacaoViewHolder, position: Int) {
        val avaliacao = dao.getAvaliacao(position)
        val nota_peso = avaliacao.nota.toString() + "/" + avaliacao.peso.toString();
        holder.txtAvaliacao.text = "${avaliacao.nome} - ${nota_peso})"
        holder.txtDataAvaliacao.text = "${avaliacao.data}"
/* todo
        holder.txtMarcaModelo.setOnLongClickListener {
            // enviar a posição do elemento atual para a DetalhesActivity
            var intent = Intent(context, DetalhesActivity::class.java)
            intent.putExtra("position", position)
            context.startActivity(intent)
            true
        }
*/
    }
    override fun getItemCount(): Int {
        return listaAvaliacao.size
    }

}
