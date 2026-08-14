package com.josealonso.vidatotal.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "actividad",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["idUsuario"],
            childColumns = ["idUsuario"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Actividad(
    @PrimaryKey(autoGenerate = true) val idActividad: Int = 0,
    val idUsuario: Int,
    val tipo: String,              // gym, hidratacion, transporte, entretenimiento, estudio
    val detalle: String? = null,   // "Tríceps", "Recarga Qrobus", "Cinépolis 4DX"
    val valorNumerico: Double = 0.0,
    val fecha: Long
)
