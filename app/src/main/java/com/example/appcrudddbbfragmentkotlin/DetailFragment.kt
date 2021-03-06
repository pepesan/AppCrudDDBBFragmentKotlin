package com.example.appcrudddbbfragmentkotlin

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController


class DetailFragment : MiFragmento() {

    val model: SharedFragmentViewModel by activityViewModels()
    var c : Cliente? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Modificando la barra
        activity?.setTitle(R.string.detail_fragment_label)
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.selected?.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.detail_text_id_label).text= it.toString()
            c = miAplicacion?.modelo?.get(it)
            view.findViewById<TextView>(R.id.detail_text_name_label).text = c?.nombre

        }
    }
    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        val item = menu.findItem(R.id.action_settings)
        item.isVisible = false
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.detail_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_detail_delete){
            Log.d("app", "Deleting: $c")
            miAplicacion?.modelo?.remove(c!!)
            findNavController().navigate(R.id.action_detailFragment_to_SecondFragment)
        }
        if(item.itemId == R.id.action_detail_edit){
            findNavController().navigate(R.id.action_detailFragment_to_editFragment)
        }
        if(item.itemId ==android.R.id.home) {
            findNavController().navigate(R.id.action_detailFragment_to_SecondFragment)
        }
        (activity as AppCompatActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(false);
        return super.onOptionsItemSelected(item)

    }

}