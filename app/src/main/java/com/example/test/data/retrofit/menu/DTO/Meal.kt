package com.example.test.data.retrofit.menu.DTO

import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("strMeal")
    var header: String? = null,
    @SerializedName("strInstructions")
    var description: String? = null,
    @SerializedName("idMeal")
    var price: String? = null,
    @SerializedName("strMealThumb")
    var icon: String? = null
)