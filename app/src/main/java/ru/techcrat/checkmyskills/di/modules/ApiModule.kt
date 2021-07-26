package ru.techcrat.checkmyskills.di.modules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.techcrat.checkmyskills.retrofit.RateApiService
import javax.inject.Singleton

@Module
class ApiModule {
    private val BASE_URL = "https://www.cbr-xml-daily.ru/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): RateApiService {
        return retrofit.create(RateApiService::class.java)
    }

}
