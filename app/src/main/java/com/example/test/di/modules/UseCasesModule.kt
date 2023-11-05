package com.example.test.di.modules

import com.example.test.domain.usecases.GetMealListFromLocalUseCase
import com.example.test.domain.usecases.GetMealListUseCase
import org.koin.dsl.module

val useCasesModule = module {
    single { GetMealListUseCase(get()) }

    single { GetMealListFromLocalUseCase(get()) }
}