package com.david.ticketmastertest.core.di.modules

import androidx.lifecycle.ViewModelProvider
import com.david.ticketmastertest.viewmodels.TicketMasterViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: TicketMasterViewModelFactory): ViewModelProvider.Factory
}