package com.example.test.di.modules

import com.example.test.presentation.menu.MenuViewModel
import com.example.test.presentation.menu.formatters.MealFormatter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { MenuViewModel(get(), get()) }

    single { MenuViewModel.MenuViewModelFactory(get(),get()) }

    single { MealFormatter() }
}