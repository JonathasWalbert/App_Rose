package com.example.app_rose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FormCadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_cadastro)
        supportActionBar?.hide()
    }
}