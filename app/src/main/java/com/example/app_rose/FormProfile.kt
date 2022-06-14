package com.example.app_rose

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FormProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_profile)
        supportActionBar?.hide()

        val btn_deslogar = findViewById(R.id.btn_deslogar) as Button
        btn_deslogar.setOnClickListener{
            val action_tela_main = Intent(this,FormLogin::class.java)
            startActivity(action_tela_main)
        }

    }
}