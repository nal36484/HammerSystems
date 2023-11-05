package com.example.test.di.modules

import com.example.test.data.mappers.MealMapper
import com.example.test.data.repositories.meal.MenuRepositoryImpl
import com.example.test.data.repositories.meal.NetworkDataSource
import com.example.test.data.repositories.meal.NetworkDataSourceImpl
import com.example.test.data.retrofit.menu.ApiService
import com.example.test.data.retrofit.menu.ApiServiceImpl
import com.example.test.domain.repositories.MenuRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val repositoriesModule = module {
    single<MenuRepository> { MenuRepositoryImpl(get()) }

    single<NetworkDataSource> { NetworkDataSourceImpl(get(), get()) }

    factory { MealMapper() }

    single { ApiServiceImpl(get()) }

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://themealdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { provideRetrofit() }

    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    single { provideApiService(get()) }
}