package ru.techcrat.checkmyskills.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.techcrat.checkmyskills.viewmodels.ViewModelFactory
import ru.techcrat.checkmyskills.di.annotations.ViewModelKey
import ru.techcrat.checkmyskills.viewmodels.DateViewModel
import ru.techcrat.checkmyskills.viewmodels.RateViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RateViewModel::class)
    abstract fun bindRateViewModel(rateFragmentViewModel: RateViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DateViewModel::class)
    abstract fun bindDateViewModel(dateFragmentViewModel: DateViewModel):ViewModel

}