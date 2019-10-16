package com.david.ticketmastertest.core.di.modules

import com.david.ticketmastertest.database.OfflineData
import com.david.ticketmastertest.network.AppExecutors
import com.david.ticketmastertest.network.TicketMasterApi
import com.david.ticketmastertest.utils.TicketMasterPreferences
import com.david.ticketmastertest.views.repositories.AttractionsRepository
import com.david.ticketmastertest.views.repositories.TicketMasterRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideAttractionsRepository(
        appExecutors: AppExecutors,
        api: TicketMasterApi,
        cache: OfflineData,
        preferences: TicketMasterPreferences
    ): AttractionsRepository {
        return TicketMasterRepository(appExecutors, api, cache, preferences)
    }
}