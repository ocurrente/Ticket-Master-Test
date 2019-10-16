package com.david.ticketmastertest.core.di.modules

import android.app.Application
import androidx.room.Room
import com.david.ticketmastertest.database.CacheDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideCacheDatabase(application: Application): CacheDatabase {
        return Room.databaseBuilder(
            application,
            CacheDatabase::class.java,
            CacheDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
}