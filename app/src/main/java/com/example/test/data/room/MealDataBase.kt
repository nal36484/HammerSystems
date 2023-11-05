package com.example.test.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [MealEntity::class], version = 1)
abstract class MealDataBase : RoomDatabase() {
    abstract fun mealDao(): MealDao
}