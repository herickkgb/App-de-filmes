package com.herick.appdefilmes.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.herick.appdefilmes.adapter.AdapterCategoria
import com.herick.appdefilmes.api.Api
import com.herick.appdefilmes.databinding.ActivityTelaPrincipalBinding
import com.herick.appdefilmes.model.Categoria
import com.herick.appdefilmes.model.Categorias
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TelaPrincipal : AppCompatActivity() {
    private var firebase = FirebaseAuth.getInstance()
    private lateinit var binding: ActivityTelaPrincipalBinding

    private lateinit var adapterCategoria: AdapterCategoria
    private val listaCategorias: MutableList<Categoria> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        deslogarApp()

        val recyclerViewFilmes = binding.recyclerViewFilmes
        recyclerViewFilmes.layoutManager = LinearLayoutManager(this)
        recyclerViewFilmes.setHasFixedSize(true)
        adapterCategoria = AdapterCategoria(this, listaCategorias)
        recyclerViewFilmes.adapter = adapterCategoria

        configurandoRetrofit()
    }

    private fun configurandoRetrofit() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://stackmobile.com.br/")
            .build()
            .create(Api::class.java)

        retrofit.listaCategorias().enqueue(object : Callback<Categorias> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Categorias>, response: Response<Categorias>) {
                if (response.code() == 200) {
                    response.body()?.let {
                        adapterCategoria.listaCategoria.addAll(it.categorias)
                        adapterCategoria.notifyDataSetChanged()

                        binding.ContainerProgressBar.visibility = View.GONE
                        binding.progressBar.visibility = View.GONE
                        binding.textCarregar.visibility = View.GONE
                    }
                }
            }

            override fun onFailure(call: Call<Categorias>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    "Erro, tente novamente mais tarde..",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }

    private fun deslogarApp() {
        binding.txtSair.setOnClickListener {
            try {
                firebase.signOut()
                startActivity(Intent(this, FormLogin::class.java))
                finish()

                Toast.makeText(this, "Usuário deslogado com sucesso.", Toast.LENGTH_SHORT).show()

            } catch (e: Exception) {

                Toast.makeText(this, "Erro ao deslogar: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }


}