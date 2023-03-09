package com.example.ejercicio10aleatorizadordeeventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityVistaCiudadBinding
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityVistaEnemigoBinding
import java.io.IOException

class VistaEnemigo : AppCompatActivity() {
    final lateinit var binding: ActivityVistaEnemigoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_enemigo)

        binding = ActivityVistaEnemigoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button6.setOnClickListener{
            val irLuchar = Intent(this, MainActivity7::class.java)
            startActivity(irLuchar)
        }

        binding.button8.setOnClickListener{
            val vueltaDado = Intent(this, MainActivity4::class.java)
            startActivity(vueltaDado)
        }

        binding.buttonStart.setOnClickListener{
            musica.start()
        }

        binding.buttonPause.setOnClickListener{
            musica.pause()
        }

        binding.buttonStop.setOnClickListener{
            musica.stop()

            try {
                musica.stop()
                musica.prepare()
                musica.seekTo(0)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}