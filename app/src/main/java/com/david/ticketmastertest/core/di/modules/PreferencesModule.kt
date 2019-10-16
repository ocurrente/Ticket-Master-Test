package com.david.ticketmastertest.core.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.david.ticketmastertest.BuildConfig
import com.david.ticketmastertest.utils.TicketMasterPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PreferencesModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences(BuildConfig.PREFS_NAME, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideTicketMasterPreferences(sharedPreferences: SharedPreferences): TicketMasterPreferences {
        return TicketMasterPreferences(sharedPreferences)
    }
}