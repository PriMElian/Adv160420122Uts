package com.example.adv160420122uts.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicineDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMedicine(medicine: Medicine)

    @Query("SELECT * FROM medicine")
    fun readAllData(): LiveData<List<Medicine>>
}