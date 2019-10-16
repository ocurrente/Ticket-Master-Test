package com.david.ticketmastertest.core.di.modules

import androidx.lifecycle.ViewModel
import com.david.ticketmastertest.core.di.ViewModelKey
import com.david.ticketmastertest.views.viewmodels.AttractionViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AttractionViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AttractionViewModel): ViewModel
}