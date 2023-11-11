package com.herick.appdefilmes.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.ktx.Firebase
import com.herick.appdefilmes.R
import com.herick.appdefilmes.databinding.ActivityFormLoginBinding
import com.herick.appdefilmes.databinding.ActivityFromCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFromCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFromCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editEmail.requestFocus()

        btVamosLa()

        btContinuar()

        btTxtEntrar()
        Firebase

    }

    private fun btTxtEntrar() {
        binding.txtEntrar.setOnClickListener {
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun btContinuar() {
        binding.btContinuar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()


            if (email.isNotEmpty() && senha.isNotEmpty()) {
                cadastro(email, senha)
            } else if (senha.isEmpty()) {
                binding.containerSenha.boxStrokeColor = Color.parseColor("#FF0000")
                binding.containerSenha.helperText = "A senha é obrigatoria"
                binding.containerEmail.boxStrokeColor = Color.parseColor("#FF018786")
            } else if (email.isEmpty()) {
                binding.containerEmail.boxStrokeColor = Color.parseColor("#FF0000")
                binding.containerEmail.helperText = "O E-mail é obrigatoria"
                binding.containerSenha.boxStrokeColor = Color.parseColor("#FF018786")

            }
        }
    }

    private fun cadastro(email: String, senha: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener { cadastro ->
                if (cadastro.isSuccessful) {
                    Toast.makeText(this, "Cadastro realizado com sucesso!!!", Toast.LENGTH_SHORT)
                        .show()

                    binding.containerEmail.helperText = ""
                    binding.containerSenha.helperText = ""

                    binding.containerEmail.boxStrokeColor = Color.parseColor("#FF018786")
                    binding.containerSenha.boxStrokeColor = Color.parseColor("#FF018786")

                    binding.editEmail.setText("")
                    binding.editEmail.setText("")

                    finish()

                }

            }.addOnFailureListener {
                val erro = it
                when {
                    erro is FirebaseAuthWeakPasswordException -> {
                        binding.containerSenha.helperText =
                            "Digite uma senha com 6 ou mais caracteres"
                        binding.containerSenha.boxStrokeColor = Color.parseColor("#FF0000")
                    }

                    erro is FirebaseAuthUserCollisionException -> {
                        binding.containerEmail.helperText = "E-mail já cadastrado"
                        binding.containerEmail.boxStrokeColor = Color.parseColor("#FF0000")
                    }

                    erro is FirebaseNetworkException -> {
                        binding.containerSenha.helperText = "Sem conexão com a Internet"
                        binding.containerSenha.boxStrokeColor = Color.parseColor("#FF0000")
                    }

                    else -> {
                        val regex = Regex(".+@.+\\..+")

                        if (regex.matches(email)) {
                            Toast.makeText(
                                this,
                                "Erro ao cadastrar usuário, tente novamente mais tarde!",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        } else {
                            Toast.makeText(
                                this,
                                "O endereço de e-mail deve conter o caractere '@'. Por favor, insira um e-mail válido.",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }

                    }

                }

            }

    }

    private fun btVamosLa() {
        binding.btVamosLa.setOnClickListener {
            val email = binding.editEmail.text.toString()

            if (email.isNotEmpty()) {
                binding.containerSenha.visibility = View.VISIBLE
                binding.btVamosLa.visibility = View.GONE
                binding.btContinuar.visibility = View.VISIBLE
                binding.btVamosLa.visibility = View.GONE
                binding.header.visibility = View.VISIBLE

                binding.txtTitulo.setText(
                    getString(R.string.textTituloCadastro)
                )

                binding.txtdescricao.setText(
                    getString(R.string.txtDescricaoCadastro)
                )

                binding.containerEmail.boxStrokeColor = Color.parseColor("#FF018786")

                binding.containerEmail.helperText = ""


            } else {
                binding.containerEmail.helperText = "E-mail obrigatório"
                binding.containerEmail.boxStrokeColor = Color.parseColor("#ff0000")
            }
        }
    }
}


