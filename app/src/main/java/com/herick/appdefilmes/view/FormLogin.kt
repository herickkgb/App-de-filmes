package com.herick.appdefilmes.view

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.herick.appdefilmes.R
import com.herick.appdefilmes.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {
    private lateinit var binding: ActivityFormLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.editEmail.requestFocus()
        clickEntrar()
        clickCadastrar()

        auth = Firebase.auth

    }

    override fun onStart() {
        super.onStart()
        // Verifique se o usuário está logado ao iniciar a atividade
        val currentUser = auth.currentUser

        if (currentUser != null) {
            // Se o usuário não estiver logado, redirecione para a tela de login
            startActivity(Intent(this, TelaPrincipal::class.java))
            finish()
        }
    }

    private fun clickCadastrar() {
        binding.txtTelaCadastro.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }
    }

    private fun clickEntrar() {
        binding.btnEntrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            when {
                email.isEmpty() -> {
                    binding.containerEmail.helperText = "Preencha o email!!"
                    binding.containerEmail.boxStrokeColor = Color.parseColor("#FF9800")
                }

                senha.isEmpty() -> {
                    binding.containerSenha.helperText = "Preencha a senha!!"
                    binding.containerSenha.boxStrokeColor = Color.parseColor("#FF9800")
                }

                else -> {
                    autenticacao(email, senha)
                }
            }
        }
    }

    private fun autenticacao(email: String, senha: String) {
        auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { login ->
            if (login.isSuccessful) {
                // If login is successful
                Toast.makeText(this, "Login feito com sucesso.", Toast.LENGTH_LONG).show()

                // Start the main activity (TelaPrincipal)
                val intent = Intent(this, TelaPrincipal::class.java)
                startActivity(intent)

                // Finish the current activity
                finish()
            }
        }.addOnFailureListener { fail ->
            // If login fails
            when {
                fail is FirebaseAuthInvalidUserException || fail is FirebaseAuthInvalidCredentialsException -> {
                    // Handle invalid user or credentials
                    Toast.makeText(
                        this,
                        "Erro ao fazer login do usuário. Verifique email ou senha",
                        Toast.LENGTH_LONG
                    ).show()
                }

                fail is FirebaseNetworkException -> {
                    // Handle network-related errors
                    Toast.makeText(
                        this,
                        "Erro de conexão. Verifique sua conexão com a internet",
                        Toast.LENGTH_LONG
                    ).show()
                }

                else -> {
                    // Handle other exceptions
                    Toast.makeText(this, "Erro ao fazer login do usuário", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}