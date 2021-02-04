package com.example.appcrudddbbfragmentkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class MiFragmento: Fragment() {
    var miActivity: MainActivity? = null
    var miAplicacion: Aplicacion ? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        miActivity= (activity as MainActivity)
        miActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true);
        // Accediendo a los datos
        miAplicacion = (miActivity?.application as Aplicacion)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        val item = menu.findItem(R.id.action_settings)
        item.isVisible = false
    }


}