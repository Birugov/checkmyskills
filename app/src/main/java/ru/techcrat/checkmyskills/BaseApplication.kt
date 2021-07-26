package ru.techcrat.checkmyskills

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.techcrat.checkmyskills.di.components.DaggerAppComponent


class BaseApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}