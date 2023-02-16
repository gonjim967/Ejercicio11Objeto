package com.example.ejercicio10aleatorizadordeeventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityVistaCiudadBinding
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityVistaMercaderBinding

class VistaMercader : AppCompatActivity() {
    final lateinit var binding: ActivityVistaMercaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_mercader)

        binding = ActivityVistaMercaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button6.setOnClickListener{
            val vistaComerciar = Intent(this, Comerciar::class.java)
            startActivity(vistaComerciar)
        }

        binding.button8.setOnClickListener{
            val vueltaAlDado = Intent(this, MainActivity4::class.java)
            startActivity(vueltaAlDado)
        }
    }
}