package com.example.test.data.repositories.meal

import com.example.test.domain.entities.MealDomain
import com.example.test.domain.entities.Result
import com.example.test.domain.repositories.MenuRepository

class MenuRepositoryImpl(
    private val networkDataSource: NetworkDataSource
) : MenuRepository {
    override suspend fun getMealList(): Result<List<MealDomain>> {
        return networkDataSource.getMealList()
    }
}