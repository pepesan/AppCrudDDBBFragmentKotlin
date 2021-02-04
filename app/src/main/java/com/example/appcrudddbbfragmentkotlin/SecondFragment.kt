package com.example.appcrudddbbfragmentkotlin

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.NavUtils
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
    var listado: List<Cliente>? = null
    var miActivity: MainActivity? = null
    var miAplicacion: Aplicacion ? = null
    private var cAdapter: ClienteAdapter? = null
    private var reciclerView: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Modificando la barra
        activity?.setTitle(R.string.second_fragment_label)
        setHasOptionsMenu(true)
        miActivity= (activity as MainActivity)
        miActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true);
        // Accediendo a los datos
        miAplicacion = (miActivity?.application as Aplicacion)
        listado= miAplicacion?.modelo?.listado
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
         */
        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_addFragment)
        }
        cAdapter = ClienteAdapter(listado!!, miActivity!!)
        val mLayoutManager = LinearLayoutManager(activity)
        this.reciclerView = view.findViewById(R.id.reciclerView)
        reciclerView!!.layoutManager = mLayoutManager
        reciclerView!!.itemAnimator = DefaultItemAnimator()
        reciclerView!!.adapter = cAdapter
    }
    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        val item = menu.findItem(R.id.action_settings)
        item.isVisible = false
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.sample_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_list_add){
            findNavController().navigate(R.id.action_SecondFragment_to_addFragment)
        }
        if(item.itemId ==android.R.id.home) {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        (activity as AppCompatActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(false);
        return super.onOptionsItemSelected(item)

    }
}