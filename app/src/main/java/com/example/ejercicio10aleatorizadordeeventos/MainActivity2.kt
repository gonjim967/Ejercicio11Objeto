package com.example.ejercicio10aleatorizadordeeventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    final lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val clase=intent.getStringExtra("CLASE")

        var raza=""
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.imageView2.setImageResource(R.drawable.humano)
            raza="humano"
        }

        binding.button2.setOnClickListener {
            binding.imageView2.setImageResource(R.drawable.goblin)
            raza="goblin"
        }

        binding.button3.setOnClickListener {
            binding.imageView2.setImageResource(R.drawable.enano)
            raza="enano"
        }

        binding.button4.setOnClickListener {
            binding.imageView2.setImageResource(R.drawable.duende)
            raza="duende"
        }

        binding.button7.setOnClickListener {
            val nuevaVista2 = Intent(this, MainActivity3::class.java)
            nuevaVista2.putExtra("RAZA", raza)
            nuevaVista2.putExtra("CLASE", clase)
            startActivity(nuevaVista2)
        }
    }
}