package com.example.appcrudddbbfragmentkotlin

import android.app.Application
import android.util.Log

class Aplicacion: Application() {
    var modelo: Modelo? = null
    var listado: List<Cliente>? = null

    override fun onCreate() {
        super.onCreate()
        Log.d("app","Application loaded")
        modelo  = Modelo(this)
        listado = ArrayList()
        Log.d("app","Loading Data from Database")
        modelo?.loadList()
        listado= modelo?.listado!!
        Log.d("app","Data loaded: $listado")
        /*
        val  c = Cliente(nombre = "David")
        Log.d("app","Inserting Object into Database: $c")
        modelo?.add(c)

        val  c = Cliente(id = 1L, nombre = "David2")
        modelo?.set(c)
        Log.d("app","Data loaded from memory: $listado")

        val c = modelo?.get(1L)
        Log.d("app","Data loaded from Memory: $c")

        modelo?.remove(Cliente(id = 1L))
        modelo?.loadList()
        Log.d("app","Data loaded from Database: $listado")

         */


    }




}