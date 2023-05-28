package com.example.drinkrecipes.presentation.mapper

import com.example.drinkrecipes.domain.model.DrinkData
import com.example.drinkrecipes.domain.model.DrinkDetailsData
import com.example.drinkrecipes.presentation.model.DrinkDetailsViewData
import com.example.drinkrecipes.presentation.model.DrinkViewData

fun DrinkData.toDrinkViewData() = DrinkViewData(
    id = id,
    name = name,
    imageUri = imageUri
)

fun DrinkDetailsData.toDrinkDetailsViewData() = DrinkDetailsViewData(
    id = id,
    name = name,
    imageUri = imageUri,
    ingredients = ingredients,
    instructions = instructions,
    instructionsDe = instructionsDe,
    instructionsEs = instructionsEs,
    instructionsFr = instructionsFr,
    instructionsIt = instructionsIt,
    instructionsZhHans = instructionsZhHans,
    instructionsZhHant = instructionsZhHant
)
