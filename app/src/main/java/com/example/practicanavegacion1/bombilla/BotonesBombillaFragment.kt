package com.example.practicanavegacion1.bombilla

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.databinding.FragmentBotonesBombillaBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BotonesBombillaFragment : Fragment() {
    private var _binding:FragmentBotonesBombillaBinding?=null
    private val binding get() = _binding!!
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var interfazBombilla:IListenerBombilla
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentBotonesBombillaBinding.inflate(inflater,container,false)
        return binding.root
    }
    //se ejecuta cuando de inicia la actividad que va a contener este fragmento
    override fun onAttach(context: Context) {
        super.onAttach(context)
        //recupera la actividad que inicia el fragmento y comprueba si es la ctividad Bombilla activita
        //o tambien valdria IListenerBombilla ya que BombillaActivity implementa dicha interfaz
        if ( activity is IListenerBombilla){
            //casting de la actividad a Interfaz para poder llamar al metodo de la interfaz una vez creada la vista
            interfazBombilla=activity as IListenerBombilla
        }else{
            throw RuntimeException()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //suscribimpos el boton a un evento y ejecutamos el metodo de IListenerBombilla
        binding.apagar.isEnabled=!binding.apagar.isEnabled
        binding.encender.setOnClickListener{
            interfazBombilla.actualizarEstado(binding.encender.id)
            cambiarEstadoBotones()
        }
        binding.apagar.setOnClickListener{
            interfazBombilla.actualizarEstado(binding.apagar.id)
            cambiarEstadoBotones()
        }
    }

    private fun cambiarEstadoBotones() {
        binding.encender.isEnabled=!binding.encender.isEnabled
        binding.apagar.isEnabled=!binding.apagar.isEnabled
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BotonesBombillaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}