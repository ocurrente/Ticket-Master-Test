package com.david.ticketmastertest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.david.ticketmastertest.database.dao.AttractionsDao
import com.david.ticketmastertest.models.Attractions


@Database(
    entities = [
        Attractions::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(CacheConverters::class)
abstract class CacheDatabase : RoomDatabase() {

    abstract fun attractionsDao(): AttractionsDao

    companion object {
        const val DATABASE_NAME = "ticket_masters_cache_database.db"
    }
}