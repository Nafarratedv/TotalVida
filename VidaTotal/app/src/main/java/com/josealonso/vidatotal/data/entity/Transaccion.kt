package com.josealonso.vidatotal.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "transaccion",
    foreignKeys = [
        ForeignKey(
            entity = CuentaFinanciera::class,
            parentColumns = ["idCuenta"],
            childColumns = ["idCuenta"],
            onDelete = ForeignKey.SET_NULL
        )
    ]
)
data class Transaccion(
    @PrimaryKey(autoGenerate = true) val idTransaccion: Int = 0,
    val idCuenta: Int? = null,
    val concepto: String,           // "Perfumes Lattafa", "Comida calle"
    val categoria: String,          // compra, comida, transporte, msi
    val monto: Double,
    val esMsi: Boolean = false,
    val mesesMsi: Int? = null,
    val fechaLimiteMsi: Long? = null,
    val fecha: Long,
    val plataforma: String? = null, // Amazon, AliExpress, MercadoLibre, tienda física
    val ahorroGenerado: Double = 0.0
)
