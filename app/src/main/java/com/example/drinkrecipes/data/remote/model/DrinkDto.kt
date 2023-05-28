package com.example.drinkrecipes.data.remote.model

import com.google.gson.annotations.SerializedName

data class DrinkDto(
    @SerializedName("idDrink")
    val id: String,
    @SerializedName("strDrink")
    val name: String,
    @SerializedName("strDrinkThumb")
    val imageUri: String
)
