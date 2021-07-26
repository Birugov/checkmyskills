package ru.techcrat.checkmyskills.di.modules

import dagger.Module
import dagger.Provides
import ru.techcrat.checkmyskills.repos.DateRepos
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDateRepo(): DateRepos {
        return DateRepos()
    }

}
