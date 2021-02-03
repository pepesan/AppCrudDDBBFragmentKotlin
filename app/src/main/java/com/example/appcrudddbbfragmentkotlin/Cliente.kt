package com.example.appcrudddbbfragmentkotlin

import java.io.Serializable

data class Cliente(
    var id: Long = 0,
    var nombre: String = "") : Serializable {
}
/*
class Cliente: Serializable {
    var id: Long? = null
    var nombre: String? = null
    init {
        id = 0
        nombre  = ""
    }
    constructor(id: Long = 0, nombre: String = ""){
        this.id = id
        this.nombre = nombre
    }

}
 */
