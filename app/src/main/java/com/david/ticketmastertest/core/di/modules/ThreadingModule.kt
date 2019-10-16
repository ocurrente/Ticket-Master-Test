package com.david.ticketmastertest.core.di.modules

import com.david.ticketmastertest.network.AppExecutors
import com.david.ticketmastertest.utils.MainThreadExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Named
import javax.inject.Singleton

@Module
class ThreadingModule {

    @Singleton
    @Provides
    @Named("DiskIOExecutor")
    fun provideDiskIOExecutor(): Executor {
        return Executors.newSingleThreadExecutor()
    }

    @Singleton
    @Provides
    @Named("NetworkIOExecutor")
    fun provideNetworkIOExecutor(): Executor {
        return Executors.newFixedThreadPool(3)
    }

    @Singleton
    @Provides
    @Named("MainThreadExecutor")
    fun provideMainThreadExecutor(): Executor {
        return MainThreadExecutor()
    }

    @Singleton
    @Provides
    fun provideAppExecutors(
        @Named("DiskIOExecutor") diskIO: Executor,
        @Named("NetworkIOExecutor") networkIO: Executor,
        @Named("MainThreadExecutor") mainThread: Executor
    ): AppExecutors {
        return AppExecutors(
            diskIO,
            networkIO,
            mainThread
        )
    }
}