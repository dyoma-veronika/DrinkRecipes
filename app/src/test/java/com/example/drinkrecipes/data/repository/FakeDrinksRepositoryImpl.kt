package com.example.drinkrecipes.data.repository

import com.example.drinkrecipes.domain.model.DrinkData
import com.example.drinkrecipes.domain.model.DrinkDetailsData
import com.example.drinkrecipes.domain.repository.DrinksRepository
import com.example.drinkrecipes.util.network.LoadingState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeDrinksRepositoryImpl : DrinksRepository {

    private val drinks = getSampleDrinks()
    private val drinkDetails = mutableMapOf<String, DrinkDetailsData>()

    override fun updateData(): Flow<LoadingState> = flow {
        emit(LoadingState.Success)
    }

    override fun getDrinks(): Flow<List<DrinkData>> = flow {
        emit(drinks)
    }

    override fun getDrinkDetails(id: String): Flow<DrinkDetailsData?> = flow {
        // Check if the drink details are already available in the repository
        val cachedDrinkDetails = drinkDetails[id]
        if (cachedDrinkDetails != null) {
            emit(cachedDrinkDetails)
        } else {
            // Simulate network request delay
            delay(500)

            // Fetch drink details from a remote source (e.g., network)
            val newDrinkDetails = fetchDrinkDetailsFromRemote(id)

            // Cache the fetched drink details in the repository
            if (newDrinkDetails != null) {
                drinkDetails[id] = newDrinkDetails
            }

            emit(newDrinkDetails)
        }
    }

    private suspend fun fetchDrinkDetailsFromRemote(id: String): DrinkDetailsData? {
        // Simulate network request delay
        delay(1000)

        // In a real implementation, you would make a network request to fetch the drink details
        // For testing purposes, you can return sample drink details based on the provided id
        return when (id) {
            "1" -> DrinkDetailsData(
                "1",
                "Drink 1",
                "imageUri1",
                listOf("Ingredient 1", "Ingredient 2"),
                "Instructions 1",
                "InstructionsDe 1",
                "InstructionsEs 1",
                "InstructionsFr 1",
                "InstructionsIt 1",
                "InstructionsZhHans 1",
                "InstructionsZhHant 1"
            )
            "2" -> DrinkDetailsData(
                "2",
                "Drink 2",
                "imageUri2",
                listOf("Ingredient 3", "Ingredient 4"),
                "Instructions 2",
                "InstructionsDe 2",
                "InstructionsEs 2",
                "InstructionsFr 2",
                "InstructionsIt 2",
                "InstructionsZhHans 2",
                "InstructionsZhHant 2"
            )
            "3" -> DrinkDetailsData(
                "3",
                "Drink 3",
                "imageUri3",
                listOf("Ingredient 5", "Ingredient 6"),
                "Instructions 3",
                "InstructionsDe 3",
                "InstructionsEs 3",
                "InstructionsFr 3",
                "InstructionsIt 3",
                "InstructionsZhHans 3",
                "InstructionsZhHant 3"
            )
            else -> null
        }
    }

    private fun getSampleDrinks(): List<DrinkData> {
        // Return sample drink data for testing
        return listOf(
            DrinkData("1", "Drink 1", "imageUri1"),
            DrinkData("2", "Drink 2", "imageUri2"),
            DrinkData("3", "Drink 3", "imageUri3")
        )
    }
}
