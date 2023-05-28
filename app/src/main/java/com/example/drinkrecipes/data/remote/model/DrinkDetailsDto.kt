package com.example.drinkrecipes.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DrinkDetailsDto(
    @SerializedName("idDrink")
    val id: String,
    @SerializedName("strDrink")
    val name: String,
    @Expose
    @SerializedName("strAlcoholic")
    val strAlcoholic: String?,
    @Expose
    @SerializedName("dateModified")
    val dateModified: String?,
    @Expose
    @SerializedName("strCategory")
    val strCategory: String?,
    @Expose
    @SerializedName("strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String?,
    @Expose
    @SerializedName("strDrinkAlternate")
    val strDrinkAlternate: String?,
    @Expose
    @SerializedName("strGlass")
    val strGlass: String?,
    @Expose
    @SerializedName("strIBA")
    val strIBA: String?,
    @Expose
    @SerializedName("strImageAttribution")
    val strImageAttribution: String?,
    @Expose
    @SerializedName("strImageSource")
    val strImageSource: String?,
    @SerializedName("strDrinkThumb")
    val imageUri: String,
    @SerializedName("strIngredient1")
    val strIngredient1: String?,
    @SerializedName("strIngredient2")
    val strIngredient2: String?,
    @SerializedName("strIngredient3")
    val strIngredient3: String?,
    @SerializedName("strIngredient4")
    val strIngredient4: String?,
    @SerializedName("strIngredient5")
    val strIngredient5: String?,
    @SerializedName("strIngredient6")
    val strIngredient6: String?,
    @SerializedName("strIngredient7")
    val strIngredient7: String?,
    @SerializedName("strIngredient8")
    val strIngredient8: String?,
    @SerializedName("strIngredient9")
    val strIngredient9: String?,
    @SerializedName("strIngredient10")
    val strIngredient10: String?,
    @SerializedName("strIngredient11")
    val strIngredient11: String?,
    @SerializedName("strIngredient12")
    val strIngredient12: String?,
    @SerializedName("strIngredient13")
    val strIngredient13: String?,
    @SerializedName("strIngredient14")
    val strIngredient14: String?,
    @SerializedName("strIngredient15")
    val strIngredient15: String?,
    @SerializedName("strInstructions")
    val instructions: String?,
    @SerializedName("strInstructionsDE")
    val instructionsDe: String?,
    @SerializedName("strInstructionsES")
    val instructionsEs: String?,
    @SerializedName("strInstructionsFR")
    val instructionsFr: String?,
    @SerializedName("strInstructionsIT")
    val instructionsIt: String?,
    @SerializedName("strInstructionsZH-HANS")
    val instructionsZhHans: String?,
    @SerializedName("strInstructionsZH-HANT")
    val instructionsZhHant: String?,
    @Expose
    @SerializedName("strMeasure1")
    val strMeasure1: String?,
    @Expose
    @SerializedName("strMeasure10")
    val strMeasure10: String?,
    @Expose
    @SerializedName("strMeasure11")
    val strMeasure11: String?,
    @Expose
    @SerializedName("strMeasure12")
    val strMeasure12: String?,
    @Expose
    @SerializedName("strMeasure13")
    val strMeasure13: String?,
    @Expose
    @SerializedName("strMeasure14")
    val strMeasure14: String?,
    @Expose
    @SerializedName("strMeasure15")
    val strMeasure15: String?,
    @Expose
    @SerializedName("strMeasure2")
    val strMeasure2: String?,
    @Expose
    @SerializedName("strMeasure3")
    val strMeasure3: String?,
    @Expose
    @SerializedName("strMeasure4")
    val strMeasure4: String?,
    @Expose
    @SerializedName("strMeasure5")
    val strMeasure5: String?,
    @Expose
    @SerializedName("strMeasure6")
    val strMeasure6: String?,
    @Expose
    @SerializedName("strMeasure7")
    val strMeasure7: String?,
    @Expose
    @SerializedName("strMeasure8")
    val strMeasure8: String?,
    @Expose
    @SerializedName("strMeasure9")
    val strMeasure9: String?,
    @Expose
    @SerializedName("strTags")
    val strTags: String?,
    @Expose
    @SerializedName("strVideo")
    val strVideo: String?
) {
    val ingredients: List<String?>
        get() {
            val ingredientsList = mutableListOf<String>()
            strIngredient1?.let { ingredientsList.add(it) }
            strIngredient2?.let { ingredientsList.add(it) }
            strIngredient3?.let { ingredientsList.add(it) }
            strIngredient4?.let { ingredientsList.add(it) }
            strIngredient5?.let { ingredientsList.add(it) }
            strIngredient6?.let { ingredientsList.add(it) }
            strIngredient7?.let { ingredientsList.add(it) }
            strIngredient8?.let { ingredientsList.add(it) }
            strIngredient9?.let { ingredientsList.add(it) }
            strIngredient10?.let { ingredientsList.add(it) }
            strIngredient11?.let { ingredientsList.add(it) }
            strIngredient12?.let { ingredientsList.add(it) }
            strIngredient13?.let { ingredientsList.add(it) }
            strIngredient14?.let { ingredientsList.add(it) }
            strIngredient15?.let { ingredientsList.add(it) }
            return ingredientsList
        }
}
