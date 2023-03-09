package com.example.ejercicio10aleatorizadordeeventos

import android.media.MediaPlayer
import android.widget.Toast
import java.io.Serializable
var musica = MediaPlayer()
class Personaje():Serializable {

    var nombre = ""
    var partidasJugadas = 0
    var tiempoJugado = 0
    var kills = 0
    var deaths = 0

    var edad = ""
        set(edad) {
            field = edad
        }

    var clase = ""

    var raza = ""
        set(raza) {
            field = raza
        }


    var cifrar = cifrado()

    constructor(nombre: String, clase: String, raza: String, edad: String) : this() {
        this.nombre = nombre
        this.clase = clase
        this.raza = raza
        this.edad = edad

    }


    fun hablar(texto: String): String {

        if (this.raza.equals("humano", ignoreCase = true))
            return hablarConHumano(texto)
        else if (this.raza.equals("Elfo", ignoreCase = true))
            return this.cifrar.cifrar(hablarConHumano(texto))
        else if (this.raza.equals("Enano", ignoreCase = true))
            return hablarConHumano(texto).uppercase()
        else if (this.raza.equals("Goblin", ignoreCase = true))
            return this.cifrar.cifrar(hablarConHumano(texto))
        else
            return "Error"


    }

    fun hablarConHumano(texto: String): String {
        if (this.edad.equals("Adolescente", ignoreCase = true)) {
            if (texto.equals("¿Como estas?"))
                return "De lujo"
            else if (texto.get(0).equals('¿') or texto.get(texto.length - 1).equals('?') and texto.uppercase()
                    .equals(texto)
            )
                return "Tranqui se lo que hago"
            else if (texto.uppercase().equals(texto))
                return "Eh relajate"
            else if (texto.equals(this.nombre, ignoreCase = true))
                return "Que Pasa?"
            else
                return "Yo que se bro no me rayes"
        } else if (this.edad.equals("Adulto", ignoreCase = true)) {
            if (texto.equals("¿Como estas?"))
                return "En la flor de la vida, pero me empieza a doler la espalda"
            else if (texto.get(0).equals('¿') or texto.get(texto.length - 1).equals('?') and texto.uppercase()
                    .equals(texto)
            )
                return "Estoy buscando la mejor solución"
            else if (texto.uppercase().equals(texto))
                return "No me levantes la voz mequetrefe"
            else if (texto.equals(this.nombre, ignoreCase = true))
                return "Necesitas algo?"
            else
                return "No sé de qué me estás hablando"

        } else if (this.edad.equals("Anciano", ignoreCase = true)) {
            if (texto.equals("¿Como estas?", ignoreCase = true))
                return "No me puedo mover"
            else if (texto.get(0).equals('¿') or texto.get(texto.length - 1).equals('?') and texto.uppercase()
                    .equals(texto)
            )
                return "Que no te escucho!"
            else if (texto.uppercase().equals(texto))
                return "Háblame más alto que no te escucho"
            else if (texto.equals(this.nombre, ignoreCase = true))
                return "Las 5 de la tarde"
            else
                return "En mis tiempos esto no pasaba"

        }
        return "Error de edad" + this.edad + this.raza
    }

    fun getKD(): Double {
        return kills.toDouble() / deaths.toDouble()
    }

    fun getDetalles(): String {
        return "El jugador $nombre lleva $partidasJugadas partidas jugadas en $tiempoJugado horas jugadas, con un resultado de $kills bajas por $deaths muertes. Por tanto el K/D es de ${getKD()}"
    }

    class Mochila: Serializable{
        var perfil="ladron"
        var limit = 100
        var peso_mochila=0
        var valor_mochila=0
        var cant_obj=0
        var objetos = mutableListOf<Objeto>()
        fun coger(vararg objetos: Objeto){
            var obj_ordenados = objetos
            obj_ordenados.sortByDescending { it.relacion }
            for (objeto in obj_ordenados) {
                print("${objeto.peso},${objeto.valor},${objeto.relacion}  ")

                if (peso_mochila + objeto.peso <= limit) {
                    this.peso_mochila = peso_mochila + objeto.peso
                    this.valor_mochila=valor_mochila+objeto.valor
                    this.cant_obj = cant_obj + 1
                    this.objetos.add(objeto)
                }



            }
        }

    }

}

class cifrado: Serializable {
    fun main(){
        var texto ="pamplona".uppercase()

        println("original: "+texto)
        println("cifrado:  "+cifrar(texto))
    }

    fun cifrar(text : String):String {
        var abecedario = Array(26) { char -> ' ' }
        var resultado = ""
        var textLower = text.lowercase()
        var texto = textLower.toCharArray()
        var clave = 13
        var conversion = 0
        abecedario[0] = 'a'
        abecedario[1] = 'b'
        abecedario[2] = 'c'
        abecedario[3] = 'd'
        abecedario[4] = 'e'
        abecedario[5] = 'f'
        abecedario[6] = 'g'
        abecedario[7] = 'h'
        abecedario[8] = 'i'
        abecedario[9] = 'j'
        abecedario[10] = 'k'
        abecedario[11] = 'l'
        abecedario[12] = 'm'
        abecedario[13] = 'n'
        abecedario[14] = 'o'
        abecedario[15] = 'p'
        abecedario[16] = 'q'
        abecedario[17] = 'r'
        abecedario[18] = 's'
        abecedario[19] = 't'
        abecedario[20] = 'u'
        abecedario[21] = 'v'
        abecedario[22] = 'w'
        abecedario[23] = 'x'
        abecedario[24] = 'y'
        abecedario[25] = 'z'
        var x = 0
        for (cT in textLower) {
            conversion = abecedario.indexOf(cT) + 13

            if (conversion > 25)
                conversion = conversion - 26
            texto[x] = abecedario[conversion]

            x++
        }
        for (car in texto) {
            resultado = "${resultado}${car}"
        }

        return resultado
    }

}
class Objeto: Serializable {

    var nombre = ""
    var peso = 0
    var valor = 0
    var relacion:Double = 0.0
    var vida = 0

    constructor(nombre: String, peso: Int, valor: Int, vida: Int) {
        this.nombre = nombre
        this.peso = peso
        this.valor = valor
        this.relacion = valor.toDouble()/peso.toDouble()
        this.vida = vida
    }

}

