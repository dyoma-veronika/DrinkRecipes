package com.example.drinkrecipes.data.remote

import com.example.drinkrecipes.data.remote.model.DrinkDetailsResponse
import com.example.drinkrecipes.data.remote.model.DrinkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksApi {
    @GET("filter.php?a=Alcoholic")
    suspend fun getDrinks(): Response<DrinkResponse>

    @GET("lookup.php")
    suspend fun getDrinkById(@Query("i") id: String): Response<DrinkDetailsResponse>
}
