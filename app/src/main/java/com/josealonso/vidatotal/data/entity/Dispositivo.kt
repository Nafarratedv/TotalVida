package com.josealonso.vidatotal.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "dispositivo",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["idUsuario"],
            childColumns = ["idUsuario"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Dispositivo(
    @PrimaryKey(autoGenerate = true) val idDispositivo: Int = 0,
    val idUsuario: Int,
    val nombre: String,             // "Galaxy S22", "ThinkPad P14s", "Cannondale Killer V"
    val categoria: String,          // smartphone, laptop, hardware_diy, bicicleta
    val estado: String,             // funcional, en_reparacion, en_restauracion
    val ultimaIntervencion: String? = null,
    val fechaIntervencion: Long? = null
)
