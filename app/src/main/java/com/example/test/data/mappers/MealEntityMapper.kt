package com.example.test.data.mappers

import com.example.test.data.room.MealEntity
import com.example.test.domain.entities.MealDomain

class MealEntityMapper {

    fun mapToDomain(mealList: List<MealEntity>): List<MealDomain> {
        return mealList.map {meal ->
            MealDomain(
                header = meal.header,
                description = meal.description,
                price = meal.id,
                icon = meal.icon
            )
        }
    }

    fun mapToEntity(mealList: List<MealDomain>): List<MealEntity> {
        return mealList.map { meal ->
            MealEntity(
                id = meal.price,
                header = meal.header,
                description = meal.description,
                icon = meal.icon
            )
        }
    }
}