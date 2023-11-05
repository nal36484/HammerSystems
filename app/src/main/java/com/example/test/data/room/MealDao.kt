package com.example.test.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMealList(mealList: List<MealEntity>)

    @Query("SELECT * FROM meal")
    fun getMealList(): Flow<List<MealEntity>>
}