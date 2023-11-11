package com.herick.appdefilmes.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.herick.appdefilmes.databinding.ActivityTelaPrincipalBinding

class TelaPrincipal : AppCompatActivity() {
    private var firebase = FirebaseAuth.getInstance()
    private lateinit var binding: ActivityTelaPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        deslogarApp()
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