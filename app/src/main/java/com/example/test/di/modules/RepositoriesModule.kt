package com.example.test.di.modules

import androidx.room.Room
import com.example.test.data.mappers.MealEntityMapper
import com.example.test.data.mappers.MealMapper
import com.example.test.data.repositories.meal.LocalDataSource
import com.example.test.data.repositories.meal.LocalDataSourceImpl
import com.example.test.data.repositories.meal.MenuRepositoryImpl
import com.example.test.data.repositories.meal.NetworkDataSource
import com.example.test.data.repositories.meal.NetworkDataSourceImpl
import com.example.test.data.retrofit.menu.ApiService
import com.example.test.data.retrofit.menu.ApiServiceImpl
import com.example.test.data.room.MealDataBase
import com.example.test.domain.repositories.MenuRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val repositoriesModule = module {
    single<MenuRepository> { MenuRepositoryImpl(get(), get()) }

    single<NetworkDataSource> { NetworkDataSourceImpl(get(), get(), get(), get()) }

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

    single<LocalDataSource> { LocalDataSourceImpl(get(), get()) }

    single {
        Room.databaseBuilder(androidContext(), MealDataBase::class.java, "mealDataBase")
            .build()
    }

    single { get<MealDataBase>().mealDao() }

    factory { MealEntityMapper() }
}