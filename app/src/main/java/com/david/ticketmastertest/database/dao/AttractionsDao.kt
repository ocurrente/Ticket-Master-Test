package com.david.ticketmastertest.database.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.david.ticketmastertest.models.Attractions

@Dao
abstract class AttractionsDao {
    @Query("SELECT * FROM attractions WHERE name LIKE '%' || :name || '%'")
    abstract fun getAttractionsLiveData(name: String): LiveData<List<Attractions>>

    @Query("SELECT * FROM attractions WHERE id = :id")
    abstract fun getAttractionDetailLiveData(id: String): LiveData<Attractions>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(list: List<Attractions>)
}