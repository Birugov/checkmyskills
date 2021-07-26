package ru.techcrat.checkmyskills.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.techcrat.checkmyskills.BaseApplication
import ru.techcrat.checkmyskills.ui.DateFragment
import ru.techcrat.checkmyskills.ui.RateFragment
import ru.techcrat.checkmyskills.di.modules.ApiModule
import ru.techcrat.checkmyskills.di.modules.RepositoryModule
import ru.techcrat.checkmyskills.di.modules.ViewModelFactoryModule
import ru.techcrat.checkmyskills.di.modules.ViewModelModule
import ru.techcrat.checkmyskills.viewmodels.DateViewModel
import ru.techcrat.checkmyskills.viewmodels.RateViewModel
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        ApiModule::class,
        RepositoryModule::class
    ]
)

interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: BaseApplication?) {
    }

    fun inject(viewModel: RateViewModel)

    fun inject(fragment: RateFragment)

    fun inject(viewModel: DateViewModel)

    fun inject(fragment: DateFragment)

}
