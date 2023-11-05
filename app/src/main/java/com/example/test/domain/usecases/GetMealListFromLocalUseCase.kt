package com.example.test.domain.usecases

import com.example.test.domain.entities.MealDomain
import com.example.test.domain.repositories.MenuRepository
import kotlinx.coroutines.flow.Flow

class GetMealListFromLocalUseCase(private val repository: MenuRepository) {
    suspend fun execute(): Flow<List<MealDomain>> {
        return repository.gelMealListFromLocal()
    }
}