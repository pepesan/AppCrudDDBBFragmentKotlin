package com.example.appcrudddbbfragmentkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

open class MiFragmento: Fragment() {
    var miActivity: MainActivity? = null
    var miAplicacion: Aplicacion ? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        miActivity= (activity as MainActivity)
        miActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true);
        // Accediendo a los datos
        miAplicacion = (miActivity?.application as Aplicacion)
    }
    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        val item = menu.findItem(R.id.action_settings)
        item.isVisible = false
    }


}