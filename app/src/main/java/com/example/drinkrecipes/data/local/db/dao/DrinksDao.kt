package com.example.drinkrecipes.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.drinkrecipes.data.local.db.entity.DrinkDetailsEntity
import com.example.drinkrecipes.data.local.db.entity.DrinkEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DrinksDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDrinks(drinks: List<DrinkEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrink(drink: DrinkDetailsEntity)

    @Query("SELECT * FROM drinks")
    fun getAllDrinks(): Flow<List<DrinkEntity>>

    @Query("SELECT * FROM drinks_details WHERE id IS (:drinkId) LIMIT 1")
    suspend fun getDrinkById(drinkId: String): DrinkDetailsEntity?
}
