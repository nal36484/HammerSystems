package com.example.test.data.repositories.meal

import com.example.test.domain.entities.MealDomain
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun getMealList(): Flow<List<MealDomain>>

    suspend fun saveMealList(mealList: List<MealDomain>)
}