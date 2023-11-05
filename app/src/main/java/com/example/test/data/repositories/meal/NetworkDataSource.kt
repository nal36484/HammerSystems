package com.example.test.data.repositories.meal

import com.example.test.domain.entities.MealDomain
import com.example.test.domain.entities.Result

interface NetworkDataSource {
    suspend fun getMealList(): Result<List<MealDomain>>
}