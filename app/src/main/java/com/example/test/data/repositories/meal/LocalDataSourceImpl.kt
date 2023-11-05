package com.example.test.data.repositories.meal

import com.example.test.data.mappers.MealEntityMapper
import com.example.test.data.room.MealDao
import com.example.test.domain.entities.MealDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDataSourceImpl(
    private val dao: MealDao,
    private val mapper: MealEntityMapper
) : LocalDataSource {
    override suspend fun getMealList(): Flow<List<MealDomain>> {
        val mealListFlow = dao.getMealList()
        return mealListFlow.map { mealList ->
            mapper.mapToDomain(mealList)
        }
    }

    override suspend fun saveMealList(mealList: List<MealDomain>) {
        dao.saveMealList(mapper.mapToEntity(mealList))
    }
}