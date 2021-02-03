package com.example.appcrudddbbfragmentkotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ClienteAdapter(private val clienteList: List<Cliente>, val context: Context) : RecyclerView.Adapter<ClienteAdapter.MyViewHolder>(){

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

        override fun onClick(view: View) {
            //navega a detalle
            val intent = Intent(context ,MainActivity::class.java)
            //intent.putExtra("title", mItem!!.title)
            //intent.putExtra("position", position)
            (context as Activity).startActivity(intent)
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
    }

    override fun getItemCount(): Int {
        return clienteList.size
    }
}
