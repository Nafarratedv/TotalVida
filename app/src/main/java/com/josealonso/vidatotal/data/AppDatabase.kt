package com.josealonso.vidatotal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.josealonso.vidatotal.data.dao.*
import com.josealonso.vidatotal.data.entity.*

@Database(
    entities = [
        Usuario::class,
        CuentaFinanciera::class,
        Transaccion::class,
        Actividad::class,
        Dispositivo::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao
    abstract fun cuentaFinancieraDao(): CuentaFinancieraDao
    abstract fun transaccionDao(): TransaccionDao
    abstract fun actividadDao(): ActividadDao
    abstract fun dispositivoDao(): DispositivoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "vidatotal_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
