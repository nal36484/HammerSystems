package com.example.test.domain.usecases

import com.example.test.domain.entities.MealDomain
import com.example.test.domain.entities.Result
import com.example.test.domain.repositories.MenuRepository

class GetMealListUseCase(private val repository: MenuRepository) {
    suspend fun execute(): Result<List<MealDomain>> {
        return repository.getMealListFromNetwork()
    }
}