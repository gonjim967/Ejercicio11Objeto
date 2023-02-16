package com.example.ejercicio10aleatorizadordeeventos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityMain3Binding
import java.util.Random

class MainActivity3 : AppCompatActivity() {
    final lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = binding.editTextTextPersonName2.text

        val clase=intent.getStringExtra("CLASE")
        val raza=intent.getStringExtra("RAZA")

        var fuerza=0;
        var defensa=0;

        if (clase.equals("guerrero")){
            binding.imageView4.setImageResource(R.drawable.guerrero)
        } else if (clase.equals("ladron")){
            binding.imageView4.setImageResource(R.drawable.ladron)
        } else if (clase.equals("mago")){
            binding.imageView4.setImageResource(R.drawable.mago)
        } else
            binding.imageView4.setImageResource(R.drawable.berserker)

        var clase_personaje = clase
        if (raza.equals("humano")){
            binding.imageView5.setImageResource(R.drawable.humano)
        } else if (raza.equals("goblin")){
            binding.imageView5.setImageResource(R.drawable.goblin)
        } else if (raza.equals("enano")){
            binding.imageView5.setImageResource(R.drawable.enano)
        }else
            binding.imageView5.setImageResource(R.drawable.duende)

        var raza_personaje = raza
        binding.textView2.setText((10..15).random().toString())
        binding.textView4.setText((1..5).random().toString())

        binding.button9.setOnClickListener{
            val nuevaVista3 = Intent(this, MainActivity::class.java)
            startActivity(nuevaVista3)
        }
        binding.button10.setOnClickListener{
            val nuevaVista4 = Intent(this, MainActivity4::class.java)
            startActivity(nuevaVista4)
        }

    }
}


