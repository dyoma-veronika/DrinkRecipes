package com.example.drinkrecipes.domain.usecase

import com.example.drinkrecipes.domain.model.DrinkData
import com.example.drinkrecipes.domain.repository.DrinksRepository
import kotlinx.coroutines.flow.Flow

class GetAllDrinksUsecase(private val drinksRepository: DrinksRepository) {
    operator fun invoke(): Flow<List<DrinkData>> =
        drinksRepository.getDrinks()
}
