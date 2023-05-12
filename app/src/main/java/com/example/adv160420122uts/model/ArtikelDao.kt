package com.example.adv160420122uts.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArtikelDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addArtikel(artikel: Artikel)

    @Query("SELECT * FROM artikel")
    fun readAllData(): LiveData<List<Artikel>>
}