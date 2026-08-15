package com.josealonso.vidatotal.data.dao

import androidx.room.*
import com.josealonso.vidatotal.data.entity.Transaccion
import kotlinx.coroutines.flow.Flow

@Dao
interface TransaccionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(transaccion: Transaccion): Long

    @Update
    suspend fun actualizar(transaccion: Transaccion)

    @Delete
    suspend fun eliminar(transaccion: Transaccion)

    @Query("SELECT * FROM transaccion ORDER BY fecha DESC")
    fun obtenerTodas(): Flow<List<Transaccion>>

    @Query("SELECT * FROM transaccion WHERE esMsi = 1 AND fechaLimiteMsi IS NOT NULL ORDER BY fechaLimiteMsi ASC")
    fun obtenerMsiActivos(): Flow<List<Transaccion>>

    @Query("SELECT SUM(ahorroGenerado) FROM transaccion WHERE fecha BETWEEN :inicio AND :fin")
    fun obtenerAhorroEnRango(inicio: Long, fin: Long): Flow<Double?>

    @Query("SELECT SUM(monto) FROM transaccion WHERE fecha BETWEEN :inicio AND :fin")
    fun obtenerGastoEnRango(inicio: Long, fin: Long): Flow<Double?>
}
