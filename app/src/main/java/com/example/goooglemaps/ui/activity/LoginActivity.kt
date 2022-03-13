package com.example.goooglemaps.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.goooglemaps.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTest.setOnClickListener {
            startActivity(Intent(this, GoogleMapActivity::class.java))
        }

        binding.appCompatButton2.setOnClickListener {
            Toast.makeText(this, "aun en produccion, ingrese al acceso de abajo", Toast.LENGTH_LONG)
                .show()
        }
        binding.appCompatButton.setOnClickListener {
            Toast.makeText(this, "aun en produccion, ingrese al acceso de abajo", Toast.LENGTH_LONG)
                .show()
        }
    }
}