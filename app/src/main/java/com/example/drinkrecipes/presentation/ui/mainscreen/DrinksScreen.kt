package com.example.drinkrecipes.presentation.ui.mainscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.drinkrecipes.presentation.ui.theme.DrinkRecipesTheme
import com.example.drinkrecipes.presentation.ui.mainscreen.components.DrinksContent
import com.example.drinkrecipes.presentation.ui.mainscreen.components.DrinksTopBar

@Composable
fun DrinksScreen(
    navigateToDetailsScreen: (id: String) -> Unit
) {
    DrinkRecipesTheme() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = {
                    DrinksTopBar()
                }
            ) { padding ->
                DrinksContent(padding = padding, navigateToDetailsScreen = navigateToDetailsScreen)
            }
        }
    }
}
