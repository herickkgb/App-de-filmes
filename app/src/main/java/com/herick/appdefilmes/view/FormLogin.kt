package com.herick.appdefilmes.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.herick.appdefilmes.R
import com.herick.appdefilmes.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {
    private lateinit var binding: ActivityFormLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editEmail.requestFocus()

        clickEntrar()

        clickCadastrar()

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

                    Toast.makeText(this, getString(R.string.preencha_o_email), Toast.LENGTH_SHORT)
                        .show()
                }

                senha.isEmpty() -> {

                    Toast.makeText(this, getString(R.string.preencha_a_senha), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}