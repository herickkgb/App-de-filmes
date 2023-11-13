package com.herick.appdefilmes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.herick.appdefilmes.databinding.CategoriaItemBinding
import com.herick.appdefilmes.model.Categoria

class AdapterCategoria constructor(
    private val context: Context,
    private val listaCategoria: MutableList<Categoria>
) : RecyclerView.Adapter<AdapterCategoria.CategoriaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val itemLista = CategoriaItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoriaViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        holder.title.text = listaCategoria[position].titulo


        val categoria = listaCategoria[position]
        holder.recyclerViewFilmes.adapter = AdapterFilme(context, categoria.filmes)

        holder.recyclerViewFilmes.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun getItemCount() = listaCategoria.size


    inner class CategoriaViewHolder(binding: CategoriaItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val title = binding.txtTitle

        val recyclerViewFilmes = binding.recyclerViewFilmes
    }
}