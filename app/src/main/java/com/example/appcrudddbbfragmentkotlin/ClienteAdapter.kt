package com.example.appcrudddbbfragmentkotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class ClienteAdapter(private val clienteList: List<Cliente>, val activity: AppCompatActivity) : RecyclerView.Adapter<ClienteAdapter.MyViewHolder>(){

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) , View.OnClickListener{
        private var mItem: Cliente? = null
        var nombre: TextView
        var miid: TextView
        var position: Int? = null

        init {
            nombre = view.findViewById<View>(R.id.title) as TextView
            miid = view.findViewById<View>(R.id.miid) as TextView
            view.setOnClickListener(this);

        }

        fun setItem(cliente: Cliente, position: Int) {
            mItem = cliente
            nombre.text = cliente.nombre
            miid.text = cliente.id.toString()
            this.position = position
        }

        override fun onClick(view: View){
            //navega a detalle
            val bundle = Bundle()
            bundle.putLong("id",mItem!!.id)
            activity.findNavController(R.id.nav_host_fragment).navigate(R.id.action_SecondFragment_to_detailFragment,bundle)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.cliente_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cliente = clienteList[position]
        holder.setItem(cliente, position)
        /*
        holder.itemView.setOnClickListener{
            Navigation.createNavigateOnClickListener(R.id.action_SecondFragment_to_detailFragment)
        }
         */
    }

    override fun getItemCount(): Int {
        return clienteList.size
    }
}
