package com.example.appcrudddbbfragmentkotlin

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController


class EditFragment : MiFragmento() {

    var c: Cliente? = null
    var nombreEditText: EditText? = null
    val model: SharedFragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle(R.string.edit_fragment_label)
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.selected?.observe(viewLifecycleOwner) {
            c = miAplicacion?.modelo?.get(it)
            Log.d("app","Edit Observe: $c")
            nombreEditText = view.findViewById<EditText>(R.id.editTextTextPersonName)
            nombreEditText?.setText(c?.nombre)

        }
    }

    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        val item = menu.findItem(R.id.action_settings)
        item.isVisible = false
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.edit_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.edit_menu_save){
            c?.nombre = nombreEditText?.text.toString()
            miAplicacion?.modelo?.set(c)
            findNavController().navigate(R.id.action_editFragment_to_detailFragment)
        }

        if(item.itemId ==android.R.id.home) {
            findNavController().navigate(R.id.action_editFragment_to_detailFragment)
        }
        (activity as AppCompatActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(false);
        return super.onOptionsItemSelected(item)

    }

}