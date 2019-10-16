package com.david.ticketmastertest.core.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class ContextModule(val application: Application) {

    @Provides
    fun providesApplicationContext(): Application {
        return application
    }
}