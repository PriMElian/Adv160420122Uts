package com.example.adv160420122uts.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DoctorDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDoctor(doctor: Doctor)

    @Query("SELECT * FROM doctor")
    fun readAllData(): LiveData<List<Doctor>>
}