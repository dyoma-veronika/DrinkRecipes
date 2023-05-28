package com.example.drinkrecipes.data.local.mapper

import com.example.drinkrecipes.data.local.db.entity.DrinkDetailsEntity
import com.example.drinkrecipes.data.local.db.entity.DrinkEntity
import com.example.drinkrecipes.domain.model.DrinkData
import com.example.drinkrecipes.domain.model.DrinkDetailsData

fun DrinkEntity.toDrinkData() = DrinkData(
    id = id,
    name = name,
    imageUri = imageUri
)

fun DrinkData.toDrinkEntity() = DrinkEntity(
    id = id,
    name = name,
    imageUri = imageUri
)

fun DrinkDetailsEntity.toDrinkDetailsData() = DrinkDetailsData(
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

fun DrinkDetailsData.toDrinkDetailsEntity() = DrinkDetailsEntity(
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
