package com.herick.appdefilmes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.herick.appdefilmes.R
import com.herick.appdefilmes.databinding.ActivityDetalhesFilmeBinding
import com.herick.appdefilmes.databinding.ActivityFromCadastroBinding

class DetalhesFilme : AppCompatActivity() {
    private lateinit var binding: ActivityDetalhesFilmeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalhesFilmeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val capa = intent.extras?.getString("capa")
        val nome = intent.extras?.getString("neme")
        val descricao = intent.extras?.getString("descricao")
        val elenco = intent.extras?.getString("elenco")

        Glide.with(this).load(capa).centerCrop().into(binding.imageCapa)
        binding.textNome.setText(nome)
        binding.txtDescricao.setText("Descrição:  $descricao")
        binding.elenco.setText("Elenco: $elenco")
    }
}