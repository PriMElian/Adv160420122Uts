/*
package com.example.adv160420122uts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class, Artikel::class, Medicine::class, Doctor::class], version = 1, exportSchema = false)
abstract class HealthcareDatabase: RoomDatabase() {
    abstract fun UserDao(): UserDao
    abstract fun DoctorrDao(): DoctorDao
    abstract fun ArtikelDao(): ArtikelDao
    abstract fun MedicineDao(): MedicineDao

    companion object {
        private var INSTANCE: HealthcareDatabase? = null

        fun getDatabase(context: Context): HealthcareDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HealthcareDatabase::class.java,
                    "kamar_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}*/
