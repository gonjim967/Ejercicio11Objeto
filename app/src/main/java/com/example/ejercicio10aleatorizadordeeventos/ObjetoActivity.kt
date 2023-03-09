package com.example.ejercicio10aleatorizadordeeventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityObjetoBinding
import java.io.IOException

class ObjetoActivity : AppCompatActivity() {
    final lateinit var binding: ActivityObjetoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objeto)

        binding = ActivityObjetoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var peso_real = 0
        val obj_cuchillo = Objeto ("cuchillo", 5, 10, 20)
        var m = Personaje.Mochila()

        binding.button6.setOnClickListener{
            m.coger(obj_cuchillo)
            peso_real = peso_real + m.peso_mochila
            Toast.makeText(this, "Hás cogido ${obj_cuchillo.nombre}, el peso de los objetos en la mochila es de ${peso_real} peso", Toast.LENGTH_SHORT).show()
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