package com.example.test.data.repositories.meal

import com.example.test.domain.entities.Result
import com.example.test.data.mappers.MealMapper
import com.example.test.data.retrofit.menu.ApiServiceImpl
import com.example.test.domain.entities.MealDomain
import com.example.test.domain.entities.StatusEnum

class NetworkDataSourceImpl(
    private val apiService: ApiServiceImpl,
    private val mapper: MealMapper
) : NetworkDataSource {
    override suspend fun getMealList(): Result<List<MealDomain>> {
        val result = apiService.getMealList()
        return if (result.isSuccessful) {
            val data = mapper.map(result.body()!!.meals)
            Result(StatusEnum.SUCCESS, data)
        } else {
            Result(StatusEnum.ERROR)
        }
    }
}