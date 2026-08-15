package com.josealonso.vidatotal.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true) val idUsuario: Int = 0,
    val nombre: String,
    val ocupacion: String? = null,
    val institucion: String? = null,
    val ciudad: String? = null,
    val ingresoQuincenal: Double = 0.0
)
