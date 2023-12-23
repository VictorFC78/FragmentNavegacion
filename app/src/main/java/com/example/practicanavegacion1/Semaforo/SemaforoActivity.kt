package com.example.practicanavegacion1.Semaforo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.databinding.ActivitySemaforoBinding

class SemaforoActivity : AppCompatActivity(),IListenerSemaforo {
    private lateinit var binding:ActivitySemaforoBinding
    private lateinit var botonSemaforo:SemaforoBotonFragment
    private lateinit var colorSemaforo: SemaforoColorFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySemaforoBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_semaforo)
        botonSemaforo=SemaforoBotonFragment.newInstance()
        colorSemaforo=SemaforoColorFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(binding.contenedorBotonSemaforo.id,botonSemaforo)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(binding.contenedorColorSemaforo.id,colorSemaforo)
            .commit()
    }

    override fun actualizarEstado(id:Int) {
        colorSemaforo.actualizarColorSemaforo()
    }

}