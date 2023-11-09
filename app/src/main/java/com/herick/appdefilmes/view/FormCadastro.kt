package com.herick.appdefilmes.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.herick.appdefilmes.R
import com.herick.appdefilmes.databinding.ActivityFormLoginBinding
import com.herick.appdefilmes.databinding.ActivityFromCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFromCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFromCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}