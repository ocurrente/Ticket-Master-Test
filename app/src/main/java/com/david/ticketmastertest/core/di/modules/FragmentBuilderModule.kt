package com.david.ticketmastertest.core.di.modules

import com.david.ticketmastertest.views.attractionsdetails.AttractionDetailsFragment
import com.david.ticketmastertest.views.attractionslist.AttractionsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeAttractionsListFragment(): AttractionsListFragment

    @ContributesAndroidInjector
    abstract fun contributeAttractionDetailsFragment(): AttractionDetailsFragment
}