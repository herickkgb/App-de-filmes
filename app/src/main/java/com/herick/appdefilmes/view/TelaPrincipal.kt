package com.herick.appdefilmes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.herick.appdefilmes.adapter.AdapterCategoria
import com.herick.appdefilmes.databinding.ActivityTelaPrincipalBinding
import com.herick.appdefilmes.model.Categoria

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
        getCategorias()
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

    private fun getCategorias() {
        val categoria1 = Categoria("Categoria 1")
        listaCategorias.add(categoria1)

        val categoria2 = Categoria("Categoria 2")
        listaCategorias.add(categoria2)

        val categoria3 = Categoria("Categoria 3")
        listaCategorias.add(categoria3)

        val categoria4 = Categoria("Categoria 4")
        listaCategorias.add(categoria4)

        val categoria5 = Categoria("Categoria 5")
        listaCategorias.add(categoria5)
    }

}