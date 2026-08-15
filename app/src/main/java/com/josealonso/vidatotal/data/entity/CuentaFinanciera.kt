package com.josealonso.vidatotal.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "cuenta_financiera",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["idUsuario"],
            childColumns = ["idUsuario"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CuentaFinanciera(
    @PrimaryKey(autoGenerate = true) val idCuenta: Int = 0,
    val idUsuario: Int,
    val banco: String,       // BBVA, Nu, Invex
    val tipo: String,        // debito, credito
    val saldoDisponible: Double = 0.0,
    val fechaCorte: Long? = null
)
