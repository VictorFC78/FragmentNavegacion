package com.example.practicanavegacion1.Semaforo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.databinding.FragmentSemaforoBotonBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SemaforoBotonFragment : Fragment() {
    private var _binding:FragmentSemaforoBotonBinding?=null
    private var param1: String? = null
    private var param2: String? = null
    private val binding get() = _binding!!
    private lateinit var iListenerSemaforo: IListenerSemaforo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    //podemos inicializar la variable de tipo interfaz cuando de adjunte el fragmento a la vista o cuando ya este credada
    //la inicializamos en el attach y recuperamos la actividad que inicia el fragemento
    override fun onAttach(context: Context) {
        super.onAttach(context)
        iListenerSemaforo=activity as IListenerSemaforo
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSemaforoBotonBinding.inflate(inflater,container,false)
        return binding.root
    }
    //con la vista creada ponemos a l boton a le escucha de click para cambiar
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonCambiarColor.setOnClickListener{
            iListenerSemaforo.actualizarEstado(binding.botonCambiarColor.id)
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            SemaforoBotonFragment()

    }
}