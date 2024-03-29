package com.example.practicanavegacion1.Semaforo

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicanavegacion1.R
import com.example.practicanavegacion1.databinding.FragmentSemaforoColorBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SemaforoColorFragment : Fragment() {
    private var _binding:FragmentSemaforoColorBinding?=null
    private var param1: String? = null
    private var param2: String? = null
    private val binding get() = _binding!!
    private val semaforo=Semaforo()
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
        // Inflate the layout for this fragmen
        _binding=FragmentSemaforoColorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtColorSemaforo.setBackgroundColor(Color.RED)
        cambiarColorSemaforo()
    }
    fun actualizarColorSemaforo() {
        semaforo.avanzar()
        cambiarColorSemaforo()

    }
    private fun cambiarColorSemaforo(){
        binding.txtColorSemaforo.setBackgroundColor(semaforo.color)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            SemaforoColorFragment()
    }
}