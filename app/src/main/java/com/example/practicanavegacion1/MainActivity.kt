package com.example.practicanavegacion1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicanavegacion1.Semaforo.SemaforoActivity
import com.example.practicanavegacion1.bombilla.BombillaActivity
import com.example.practicanavegacion1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val botonBombilla=binding.Bombilla//variable de enlaze con el boton Bombilla
        botonBombilla.setOnClickListener{//ponemos a la escucha del click a boton y ralizamos accion
            val intento= Intent(this,BombillaActivity::class.java)//mandamos un ointento a Bombilla acrividad
            startActivity(intento)//inicia la actidad mediante el intento que la invoca
        }
        val botonSemaforo=binding.Semaforo//variable para el boton semaforo
        botonSemaforo.setOnClickListener {
            val intentoSemaforo = Intent(this, SemaforoActivity::class.java)
            startActivity(intentoSemaforo)
        }
    }
}