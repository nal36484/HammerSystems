package com.example.test.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal")
data class MealEntity(
    @PrimaryKey
    val id: String,
    val header: String,
    val description: String,
    val icon: String
)
