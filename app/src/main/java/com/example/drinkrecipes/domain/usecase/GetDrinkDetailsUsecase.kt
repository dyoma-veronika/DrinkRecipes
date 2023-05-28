package com.example.drinkrecipes.domain.usecase

import com.example.drinkrecipes.domain.model.DrinkDetailsData
import com.example.drinkrecipes.domain.repository.DrinksRepository
import kotlinx.coroutines.flow.Flow

class GetDrinkDetailsUsecase(private val drinksRepository: DrinksRepository) {
    operator fun invoke(id: String): Flow<DrinkDetailsData?> =
        drinksRepository.getDrinkDetails(id)
}
