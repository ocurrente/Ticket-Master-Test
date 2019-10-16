package com.david.ticketmastertest.core.di.modules

import com.david.ticketmastertest.views.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}