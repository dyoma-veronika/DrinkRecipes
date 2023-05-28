package com.example.drinkrecipes.domain.service

import com.example.drinkrecipes.domain.model.DrinkData
import com.example.drinkrecipes.domain.model.DrinkDetailsData
import com.example.drinkrecipes.util.network.RequestState

interface NetworkService {

    suspend fun getAllDrinks(): RequestState<List<DrinkData>?>

    suspend fun getDrinkById(id: String): RequestState<DrinkDetailsData?>
}
