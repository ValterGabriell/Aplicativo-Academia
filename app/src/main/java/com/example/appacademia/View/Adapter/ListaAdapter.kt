package com.example.appacademia.View.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appacademia.Database.DataModel
import com.example.appacademia.R

class ListaAdapter(val lista : List<DataModel>) : RecyclerView.Adapter<ListaAdapter.ListaViewHolder>() {
    inner class ListaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        fun bind(dataModel: DataModel) {
            itemView.findViewById<TextView>(R.id.txtNameS).text = "${dataModel.name} ${dataModel.sobrename}"
            itemView.findViewById<TextView>(R.id.txtId).text = "id: ${dataModel.id}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return ListaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}