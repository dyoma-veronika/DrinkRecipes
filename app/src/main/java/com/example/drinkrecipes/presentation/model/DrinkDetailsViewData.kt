package com.example.drinkrecipes.presentation.model

data class DrinkDetailsViewData(
    val id: String,
    val name: String,
    val imageUri: String,
    val ingredients: List<String?>,
    val instructions: String?,
    val instructionsDe: String?,
    val instructionsEs: String?,
    val instructionsFr: String?,
    val instructionsIt: String?,
    val instructionsZhHans: String?,
    val instructionsZhHant: String?
)
