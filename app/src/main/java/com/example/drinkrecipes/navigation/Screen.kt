package com.example.drinkrecipes.navigation

import com.example.drinkrecipes.util.Constants.DETAILS_SCREEN
import com.example.drinkrecipes.util.Constants.DRINKS_SCREEN


sealed class Screen(val route: String) {
    object MainScreen : Screen(DRINKS_SCREEN)
    object DetailsScreen : Screen(DETAILS_SCREEN)
}
