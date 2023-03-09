package com.example.ejercicio10aleatorizadordeeventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityVistaCiudadBinding
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityVistaMercaderBinding
import java.io.IOException

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