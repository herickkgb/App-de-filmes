package com.herick.appdefilmes.adapter

import android.content.Context
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.herick.appdefilmes.databinding.FilmeItemBinding
import com.herick.appdefilmes.model.Filme

class AdapterFilme(private val context: Context, val listFilmes: MutableList<Filme>) :
    RecyclerView.Adapter<AdapterFilme.FilmeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val itemLista = FilmeItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return FilmeViewHolder(itemLista)
    }

    override fun getItemCount() = listFilmes.size

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        holder.capa.setImageResource(listFilmes[position].capa!!)
    }


    inner class FilmeViewHolder(binding: FilmeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val capa = binding.capaDoFilme
    }
}