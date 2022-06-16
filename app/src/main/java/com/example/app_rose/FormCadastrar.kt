package com.example.app_rose

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app_rose.databinding.ActivityFormCadastrarBinding
import com.example.app_rose.databinding.ActivityFormLoginBinding
import com.google.firebase.auth.FirebaseAuth

class FormCadastrar : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityFormCadastrarBinding

    val message = arrayOf("Preencha todos os campos", "Cadastro realizado com sucesso")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastrarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        firebaseAuth = FirebaseAuth.getInstance()
        binding.btnCadastrar.setOnClickListener {
            val name = binding.editName.text.toString()
            val email = binding.editEmail.text.toString()
            val password = binding.editSenha.text.toString()

            if (email.isEmpty() || password.isEmpty() || name.isEmpty()){
                Toast.makeText(this, message[0], Toast.LENGTH_SHORT).show()
            } else {
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
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