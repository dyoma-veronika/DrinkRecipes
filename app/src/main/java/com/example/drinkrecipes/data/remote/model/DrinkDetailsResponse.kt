package com.example.drinkrecipes.data.remote.model

import com.google.gson.annotations.SerializedName

data class DrinkDetailsResponse(@SerializedName("drinks") val drinkDetails: List<DrinkDetailsDto>)
