package com.example.test.data.mappers

import com.example.test.data.retrofit.menu.DTO.Meal
import com.example.test.domain.entities.MealDomain

class MealMapper {
    fun map(dto: List<Meal>): List<MealDomain> {
        return dto.mapNotNull { dto ->
            if (dto.header != null
                && dto.description != null
                && dto.price != null
                && dto.icon != null) {
                MealDomain(dto.header!!, dto.description!!, dto.price!!, dto.icon!!)
            } else {
                null
            }
        }
    }
}