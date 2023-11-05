package com.example.test.domain.repositories

import com.example.test.domain.entities.MealDomain
import com.example.test.domain.entities.Result
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    suspend fun getMealListFromNetwork(): Result<List<MealDomain>>

    suspend fun gelMealListFromLocal(): Flow<List<MealDomain>>

    suspend fun saveMealList(mealList: List<MealDomain>)
}