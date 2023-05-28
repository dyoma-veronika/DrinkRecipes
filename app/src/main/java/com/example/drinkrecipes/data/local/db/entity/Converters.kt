package com.example.drinkrecipes.data.local.db.entity

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromIngredientsList(ingredients: List<String>): String {
        return ingredients.joinToString(",")
    }

    @TypeConverter
    fun toIngredientsList(ingredientsString: String): List<String> {
        return ingredientsString.split(",")
    }
}
