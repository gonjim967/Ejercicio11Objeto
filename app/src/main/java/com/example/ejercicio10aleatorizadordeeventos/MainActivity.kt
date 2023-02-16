package com.example.ejercicio10aleatorizadordeeventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    final lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var clase=""
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.imageView2.setImageResource(R.drawable.guerrero)
            clase="guerrero"
        }

        binding.button2.setOnClickListener {
            binding.imageView2.setImageResource(R.drawable.ladron)
            clase="ladron"
        }

        binding.button3.setOnClickListener {
            binding.imageView2.setImageResource(R.drawable.mago)
            clase="mago"
        }

        binding.button4.setOnClickListener {
            binding.imageView2.setImageResource(R.drawable.berserker)
            clase="berserker"
        }

        binding.button7.setOnClickListener {
            val nuevaVista = Intent(this, MainActivity2::class.java)
            nuevaVista.putExtra("CLASE", clase)
            startActivity(nuevaVista)
        }
    }
}