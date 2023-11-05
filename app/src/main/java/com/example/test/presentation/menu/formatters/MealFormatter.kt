package com.example.test.presentation.menu.formatters

import com.example.test.domain.entities.MealDomain
import com.example.test.presentation.menu.models.MealInfo

class MealFormatter  {
    fun format(mealList: List<MealDomain>): List<MealInfo> {
        return mealList.map { meal ->
            val price = formatPrice(meal.price)
            MealInfo(
                id = meal.price,
                header = meal.header,
                description = meal.description,
                price = price,
                icon = meal.icon
            )
        }
    }

    private fun formatPrice(price: String): String {
        var result = price.toInt()
        while (result > 1000) {
            result /= 10
        }
        return String.format("от %d р", result)
    }
}