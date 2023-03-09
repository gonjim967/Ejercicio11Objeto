package com.example.ejercicio10aleatorizadordeeventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejercicio10aleatorizadordeeventos.MainActivity4.personaje.p
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityObjetoBinding
import java.io.IOException

class ObjetoActivity : AppCompatActivity() {
    final lateinit var binding: ActivityObjetoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)

        binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val obj_cuchillo = Objeto ("cuchillo", 5, 10, 20)

        binding.button6.setOnClickListener{
            p.mochila.coger(obj_cuchillo)
            Toast.makeText(this, "Hás cogido ${obj_cuchillo.nombre}, el peso de los objetos en la mochila es de ${p.mochila.peso_mochila} peso", Toast.LENGTH_SHORT).show()
            val vistaMain5 = Intent(this, MainActivity4::class.java)
            startActivity(vistaMain5)
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