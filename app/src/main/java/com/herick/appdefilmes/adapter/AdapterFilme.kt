package com.herick.appdefilmes.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.herick.appdefilmes.databinding.FilmeItemBinding
import com.herick.appdefilmes.model.Filme
import com.herick.appdefilmes.view.DetalhesFilme
import com.herick.appdefilmes.view.FormLogin

class AdapterFilme(private val context: Context, val listFilmes: MutableList<Filme>) :
    RecyclerView.Adapter<AdapterFilme.FilmeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val itemLista = FilmeItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return FilmeViewHolder(itemLista)
    }

    override fun getItemCount() = listFilmes.size

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        Glide.with(context).load(listFilmes[position].capa).centerCrop().into(holder.capa)

        holder.capa.setOnClickListener {
            val intent = Intent(context, DetalhesFilme::class.java)
            intent.putExtra("capa", listFilmes[position].capa)
            intent.putExtra("nome", listFilmes[position].nome)
            intent.putExtra("descricao", listFilmes[position].descricao)
            intent.putExtra("elenco", listFilmes[position].elenco)
            context.startActivity(intent)
        }
    }


    inner class FilmeViewHolder(binding: FilmeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val capa = binding.capaDoFilme
    }
}