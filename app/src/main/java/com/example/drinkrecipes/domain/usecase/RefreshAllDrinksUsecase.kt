package com.example.drinkrecipes.domain.usecase

import com.example.drinkrecipes.domain.repository.DrinksRepository
import com.example.drinkrecipes.util.network.LoadingState
import kotlinx.coroutines.flow.Flow

class RefreshAllDrinksUsecase(private val drinksRepository: DrinksRepository) {
    operator fun invoke(): Flow<LoadingState> = drinksRepository.updateData()
}
