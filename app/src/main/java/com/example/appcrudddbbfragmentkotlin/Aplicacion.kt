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

        var  c = Cliente(nombre = "David")
        Log.d("app","Inserting Object into Database: $c")
        modelo?.add(c)
        Log.d("app","Insert: Data loaded from Memory: $c")
        Log.d("app","Data loaded from memory: $listado")

        c = modelo?.get(c.id) as Cliente
        Log.d("app","Get: Data loaded from Memory: $c")

        c = Cliente(id = c.id, nombre = "David2")
        modelo?.set(c)
        Log.d("app","Edit: Data loaded from Memory: $c")
        Log.d("app","Data loaded from memory: $listado")

        c = modelo?.get(c.id) as Cliente
        Log.d("app","Get: Data loaded from Memory: $c")

        //modelo?.remove(Cliente(id = 2L))
        modelo?.remove(Cliente(id = c.id))
        //modelo?.loadList()
        Log.d("app","Data loaded from Database: $listado")




    }




}