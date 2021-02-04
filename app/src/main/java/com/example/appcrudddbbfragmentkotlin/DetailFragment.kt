package com.example.appcrudddbbfragmentkotlin

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var miActivity: MainActivity? = null
    var miAplicacion: Aplicacion ? = null
    private val model: SharedFragmentViewModel by activityViewModels()
    var c : Cliente? = null
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
        // Modificando la barra
        activity?.setTitle(R.string.detail_fragment_label)
        setHasOptionsMenu(true)
        miActivity= (activity as MainActivity)
        miActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true);
        // Accediendo a los datos
        miAplicacion = (miActivity?.application as Aplicacion)
        // Inflate the layout for this fragment
        Log.d("app", "Detail id param value: "+savedInstanceState?.getString("id"))
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
            val id = model.selected?.value
            miAplicacion?.modelo?.remove(c!!)
            findNavController().navigate(R.id.action_detailFragment_to_SecondFragment)
        }
        if(item.itemId ==android.R.id.home) {
            findNavController().navigate(R.id.action_detailFragment_to_SecondFragment)
        }
        (activity as AppCompatActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(false);
        return super.onOptionsItemSelected(item)

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}