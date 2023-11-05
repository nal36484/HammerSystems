package com.example.test.data.repositories.meal

import com.example.test.domain.entities.MealDomain
import com.example.test.domain.entities.Result
import com.example.test.domain.repositories.MenuRepository
import kotlinx.coroutines.flow.Flow

class MenuRepositoryImpl(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource
) : MenuRepository {
    override suspend fun getMealListFromNetwork(): Result<List<MealDomain>> {
        return networkDataSource.getMealList()
    }

    override suspend fun gelMealListFromLocal(): Flow<List<MealDomain>> {
        return localDataSource.getMealList()
    }

    override suspend fun saveMealList(mealList: List<MealDomain>) {
        localDataSource.saveMealList(mealList)
    }
}