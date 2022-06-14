package com.example.app_rose

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class FormLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_login)
        supportActionBar?.hide()

        val text_tela_cadastro: TextView = findViewById(R.id.text_tela_cadastro) as TextView
        text_tela_cadastro.setOnClickListener{
            val action_tela_cadastro = Intent(this,FormCadastro::class.java)
            startActivity(action_tela_cadastro)
        }
    }
}