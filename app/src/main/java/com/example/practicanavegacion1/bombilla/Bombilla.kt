package com.example.practicanavegacion1.bombilla

class Bombilla {
    private var encendida:Boolean=false
    fun encender(){
        encendida=true
    }
    fun apagar(){
        encendida=false
    }
    fun estaEncendida():Boolean{
        return encendida
    }
}