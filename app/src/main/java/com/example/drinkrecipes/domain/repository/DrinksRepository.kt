package com.example.drinkrecipes.domain.repository

import com.example.drinkrecipes.domain.model.DrinkData
import com.example.drinkrecipes.domain.model.DrinkDetailsData
import com.example.drinkrecipes.util.network.LoadingState
import kotlinx.coroutines.flow.Flow

interface DrinksRepository {

    fun updateData(): Flow<LoadingState>

    fun getDrinks(): Flow<List<DrinkData>>

    fun getDrinkDetails(id: String): Flow<DrinkDetailsData?>
}
