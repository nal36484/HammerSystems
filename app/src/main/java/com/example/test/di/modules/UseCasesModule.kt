package com.example.test.di.modules

import com.example.test.domain.usecases.GetMealListUseCase
import org.koin.dsl.module
import kotlin.math.sin

val useCasesModule = module {
    single { GetMealListUseCase(get()) }
}