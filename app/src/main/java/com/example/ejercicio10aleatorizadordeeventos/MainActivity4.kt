package com.example.ejercicio10aleatorizadordeeventos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlin.random.Random
import com.example.ejercicio10aleatorizadordeeventos.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    final lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var numDado=0
        var encontrar=""
        binding.button5.setOnClickListener{

            numDado=tirarDado()

            if (numDado.equals(1)){
                encontrar = "Has encontrado un Objeto"
                val vistaObjeto = Intent(this, ObjetoActivity::class.java)
                startActivity(vistaObjeto)
            }
            else if (numDado.equals(2)){
                encontrar = "Has encontrado una Ciudad"
                val vistaCiudad = Intent(this, VistaCiudad::class.java)
                startActivity(vistaCiudad)
            }
            else if (numDado.equals(3)){
                encontrar = "Has encontrado un Mercader"
                val vistaMercader = Intent(this, VistaMercader::class.java)
                startActivity(vistaMercader)
            }
            else{
                encontrar = "Te has encontrado a un enemigo"
                val vistaEnemigo = Intent(this, VistaEnemigo::class.java)
                startActivity(vistaEnemigo)
            }
            Toast.makeText(this, encontrar, Toast.LENGTH_SHORT).show()
        }

    }

    fun tirarDado(): Int {

        var numMin=1
        var numMax=5

        var numDado=0

        numDado=Random.nextInt(numMin, numMax)


        return numDado
    }
}