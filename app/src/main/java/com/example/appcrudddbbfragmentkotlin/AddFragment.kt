package com.example.appcrudddbbfragmentkotlin

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar


class AddFragment : MiFragmento() {

    var nameEditText: EditText? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        activity?.setTitle(R.string.add_fragment_label)
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nameEditText = view.findViewById(R.id.editTextTextPersonName)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.add_menu_add){
            val c = Cliente(nombre = nameEditText?.text.toString())
            //Log.d("app","Client added: "+ c)
            miAplicacion?.modelo?.add(c)
            //Log.d("app","listado after add: "+ miAplicacion?.modelo?.listado)
            findNavController().navigate(R.id.action_addFragment_to_SecondFragment)
        }
        if(item.itemId ==android.R.id.home) {
            findNavController().navigate(R.id.action_addFragment_to_SecondFragment)
        }
        (activity as AppCompatActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(false);
        return super.onOptionsItemSelected(item)

    }

}