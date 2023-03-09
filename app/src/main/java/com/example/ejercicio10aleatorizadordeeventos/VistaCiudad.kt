package com.example.ejercicio10aleatorizadordeeventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityObjetoBinding
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityVistaCiudadBinding
import java.io.IOException

class VistaCiudad : AppCompatActivity() {
    final lateinit var binding: ActivityVistaCiudadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vista_ciudad)

        binding = ActivityVistaCiudadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button6.setOnClickListener{
            var ciudad = "roma"
            val vistaMain6 = Intent(this, MainActivity6::class.java)
            startActivity(vistaMain6)
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