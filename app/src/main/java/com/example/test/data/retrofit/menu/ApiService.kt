package com.example.test.data.retrofit.menu

import com.example.test.data.retrofit.menu.DTO.MealDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("api/json/v1/1/search.php?f=b")
    suspend fun getMealList(): Response<MealDto>
}