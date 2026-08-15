package com.josealonso.vidatotal.data.dao

import androidx.room.*
import com.josealonso.vidatotal.data.entity.Actividad
import kotlinx.coroutines.flow.Flow

@Dao
interface ActividadDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(actividad: Actividad): Long

    @Update
    suspend fun actualizar(actividad: Actividad)

    @Delete
    suspend fun eliminar(actividad: Actividad)

    @Query("SELECT * FROM actividad WHERE tipo = :tipo ORDER BY fecha DESC")
    fun obtenerPorTipo(tipo: String): Flow<List<Actividad>>

    @Query("SELECT * FROM actividad ORDER BY fecha DESC LIMIT 50")
    fun obtenerRecientes(): Flow<List<Actividad>>
}
