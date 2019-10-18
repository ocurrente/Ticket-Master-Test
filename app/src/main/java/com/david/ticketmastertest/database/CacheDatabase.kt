package com.david.ticketmastertest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.david.ticketmastertest.database.dao.EventsDao
import com.david.ticketmastertest.models.events.Events


@Database(
    entities = [
        Events::class
    ],
    version = 2,
    exportSchema = false
)
@TypeConverters(CacheConverters::class)
abstract class CacheDatabase : RoomDatabase() {

    abstract fun eventsDao(): EventsDao

    companion object {
        const val DATABASE_NAME = "ticket_masters_cache_database.db"
    }
}