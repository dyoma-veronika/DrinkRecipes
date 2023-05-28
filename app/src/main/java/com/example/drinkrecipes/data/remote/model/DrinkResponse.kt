package com.example.drinkrecipes.data.remote.model

import com.google.gson.annotations.SerializedName

data class DrinkResponse(@SerializedName("drinks") val drinks: List<DrinkDto>)
