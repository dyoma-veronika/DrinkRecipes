package com.example.drinkrecipes.data.remote.mapper

import com.example.drinkrecipes.data.remote.model.DrinkDetailsDto
import com.example.drinkrecipes.data.remote.model.DrinkDto
import com.example.drinkrecipes.domain.model.DrinkData
import com.example.drinkrecipes.domain.model.DrinkDetailsData


fun DrinkDto.toDrinkData() = DrinkData(
    id = id,
    name = name,
    imageUri = imageUri
)

fun DrinkDetailsDto.toDrinkDetailsData() = DrinkDetailsData(
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
