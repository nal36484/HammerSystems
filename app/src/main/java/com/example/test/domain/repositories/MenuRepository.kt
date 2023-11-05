package com.example.test.domain.repositories

import com.example.test.domain.entities.MealDomain
import com.example.test.domain.entities.Result

interface MenuRepository {
    suspend fun getMealList(): Result<List<MealDomain>>
}