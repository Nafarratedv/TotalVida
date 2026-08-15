package com.josealonso.vidatotal.data.dao

import androidx.room.*
import com.josealonso.vidatotal.data.entity.CuentaFinanciera
import kotlinx.coroutines.flow.Flow

@Dao
interface CuentaFinancieraDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(cuenta: CuentaFinanciera): Long

    @Update
    suspend fun actualizar(cuenta: CuentaFinanciera)

    @Delete
    suspend fun eliminar(cuenta: CuentaFinanciera)

    @Query("SELECT * FROM cuenta_financiera WHERE idUsuario = :idUsuario")
    fun obtenerPorUsuario(idUsuario: Int): Flow<List<CuentaFinanciera>>
}
