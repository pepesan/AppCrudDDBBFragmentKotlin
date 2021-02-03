package com.example.appcrudddbbfragmentkotlin


import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import java.util.ArrayList

class Modelo internal constructor(application: Aplicacion) {

    private val  db: SQLiteDatabase

    var listado: MutableList<Cliente>

    init {
        //Esto podría paralelizarse
        val helper = ClientSqliteHelper(application)

        db = helper.writableDatabase
        listado = ArrayList()
    }

    fun loadList() {
        listado = ArrayList()
        val clientCursor = db.query(ClientSqliteHelper.CLIENT_TABLE,
            arrayOf(ClientSqliteHelper.CLIENT_ID, ClientSqliteHelper.CLIENT_NAME,), null, null, null, null,
            //String.format("%s,%s",PERSON_GLOBAL, PERSON_NAME )
            String.format("%s",
                ClientSqliteHelper.CLIENT_NAME))
        clientCursor.moveToFirst()
        var c: Cliente
        if (!clientCursor.isAfterLast) {
            do {
                val id = clientCursor.getLong(0)
                val name = clientCursor.getString(1)
                /*
                val tlf = clientCursor.getString(2)
                val global = clientCursor.getFloat(3)
                val filename = clientCursor.getString(4)
                val thumbfilename = clientCursor.getString(5)
                val location = clientCursor.getString(6)
                 */
                c = Cliente(id, name)
                listado!!.add(c)
            } while (clientCursor.moveToNext())
        }

        clientCursor.close()

    }
    fun add(c: Cliente?) {
        assert(null != c)

        val values = ContentValues()
        values.put(ClientSqliteHelper.CLIENT_NAME, c!!.nombre)
        c.id = db.insert(ClientSqliteHelper.CLIENT_TABLE, null, values)

        listado!!.add(c)
    }
    fun set(c: Cliente?) {
        assert(null != c)
        val values = ContentValues()
        values.put(ClientSqliteHelper.CLIENT_NAME, c!!.nombre)
        val id = c.id!!
        Log.d("id", "" + id)
        val where = String.format("%s = %d",
            ClientSqliteHelper.CLIENT_ID, id)

        db.update(ClientSqliteHelper.CLIENT_TABLE, values, where, null)
        val tam = listado!!.size
        for (i in 0 until tam) {
            val p2 = listado!![i]
            if (c.id == p2.id) {
                listado!![i] = c
                break
            }
        }
    }
    operator fun get(id: Long?): Cliente {
        val count = listado!!.size
        for (i in 0 until count) {
            val c = listado!![i]
            if (c.id == id) {
                return c
            }
        }
        return Cliente()
    }
    fun remove(c: Cliente) {
        val where = String.format("%s = %s",
            ClientSqliteHelper.CLIENT_ID,
            c.id)
        db.delete(ClientSqliteHelper.CLIENT_TABLE, where, null)
        listado!!.remove(c)
    }
}
