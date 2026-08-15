package com.josealonso.vidatotal.data.dao

import androidx.room.*
import com.josealonso.vidatotal.data.entity.Dispositivo
import kotlinx.coroutines.flow.Flow

@Dao
interface DispositivoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(dispositivo: Dispositivo): Long

    @Update
    suspend fun actualizar(dispositivo: Dispositivo)

    @Delete
    suspend fun eliminar(dispositivo: Dispositivo)

    @Query("SELECT * FROM dispositivo WHERE idUsuario = :idUsuario")
    fun obtenerPorUsuario(idUsuario: Int): Flow<List<Dispositivo>>
}
