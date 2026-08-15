package com.josealonso.vidatotal.data.dao

import androidx.room.*
import com.josealonso.vidatotal.data.entity.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(usuario: Usuario): Long

    @Update
    suspend fun actualizar(usuario: Usuario)

    @Query("SELECT * FROM usuario LIMIT 1")
    fun obtenerUsuario(): Flow<Usuario?>
}
