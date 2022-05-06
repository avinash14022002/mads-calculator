package com.example.madscalucator.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.madscalucator.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        binding.btnLogin.setOnClickListener {
//            if (username == "123" && password=="123") {
            startActivity(Intent(this, CalculatorActivity::class.java))
//            }else{
//                val toast = Toast.makeText(applicationContext, "Invalid username", Toast.LENGTH_SHORT)
//                toast.show()
//            }
        }
    }
}