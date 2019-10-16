package com.david.ticketmastertest.core.di

import android.app.Application
import android.content.Context
import com.david.ticketmastertest.core.TicketMasterApp
import com.david.ticketmastertest.core.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        PreferencesModule::class,
        ThreadingModule::class,
        ActivityBuilderModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        FragmentBuilderModule::class,
        RepositoriesModule::class
    ]
)
interface AppComponent : AndroidInjector<TicketMasterApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}