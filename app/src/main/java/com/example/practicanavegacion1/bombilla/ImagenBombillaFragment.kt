package com.example.practicanavegacion1.bombilla

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.databinding.FragmentImagenBombillaBinding




class ImagenBombillaFragment : Fragment() {
    private var _binding:FragmentImagenBombillaBinding?=null

    private val binding get() = _binding!!
    private val bombilla=Bombilla()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentImagenBombillaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actualizarImagenBombilla()
    }
    fun actualizaEstadoBombilla(id: Int) {
        if(id==R.id.encender){
            bombilla.encender()
        }
        if(id==R.id.apagar){
            bombilla.apagar()
        }
        actualizarImagenBombilla()
    }
    fun actualizarImagenBombilla(){
        if(bombilla.estaEncendida()){
            binding.imagenBombilla.setImageResource(R.drawable.encendida)
        }else{
            binding.imagenBombilla.setImageResource(R.drawable.apagada)
        }
    }

}