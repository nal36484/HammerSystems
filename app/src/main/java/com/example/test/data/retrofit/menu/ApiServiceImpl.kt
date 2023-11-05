package com.example.test.data.retrofit.menu

import com.example.test.data.retrofit.menu.DTO.MealDto
import retrofit2.Response

class ApiServiceImpl(private val apiService: ApiService) {
    suspend fun getMealList(): Response<MealDto> {
        return apiService.getMealList()
    }
}