package com.example.practicanavegacion1.bombilla

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.databinding.ActivityBombillaBinding

class BombillaActivity : AppCompatActivity(),IListenerBombilla {
    private lateinit var binding: ActivityBombillaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBombillaBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun actualizarEstado(id:Int) {
        /*
        se recupera la instancia del contenedor de fragmento imagen bombilla ya qe es el fragmento que va a cambiar su
        aspecto en timpo de ejecucion, para ello mediante el valor de id hacemos cambios en em dto bombilla cambiando
        tambien en layout que recibe el contenedor
         */
        val imagenBombillaFragment=supportFragmentManager
            .findFragmentById(R.id.container_bombilla) as ImagenBombillaFragment
        imagenBombillaFragment.actualizaEstadoBombilla(id)
    }
}