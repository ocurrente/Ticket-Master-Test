package com.david.ticketmastertest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.david.ticketmastertest.models.events.Events

@Dao
abstract class EventsDao {
    @Query("SELECT * FROM events WHERE name LIKE '%' || :name || '%'")
    abstract fun getEventsLiveData(name: String): LiveData<List<Events>>

    @Query("SELECT * FROM events WHERE id = :id")
    abstract fun getEventsDetailLiveData(id: String): LiveData<Events>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(list: List<Events>)
}