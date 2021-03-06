package com.example.app_rose

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.app_rose.databinding.ActivityFormLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthSettings

class FormLogin : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityFormLoginBinding

    val message = arrayOf("Preencha todos os campos","Usuario ou senha incorreto")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.textTelaCadastro.setOnClickListener {
            var intent = Intent(this,FormCadastrar::class.java)
            startActivity(intent)
        }

        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnEntrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.editSenha.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, message[0], Toast.LENGTH_SHORT).show()
            } else {
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                    if(it.isSuccessful){
                        var intent = Intent(this,FormProfile::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, message[1], Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        fun onStart() {
            super.onStart()
            if (firebaseAuth.currentUser != null) {
                val intent = Intent(this,FormProfile::class.java)
                startActivity(intent)
            }
        }
    }
}