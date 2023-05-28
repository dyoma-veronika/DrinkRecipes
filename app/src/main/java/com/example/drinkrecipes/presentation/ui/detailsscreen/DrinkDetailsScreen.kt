package com.example.drinkrecipes.presentation.ui.detailsscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.drinkrecipes.presentation.ui.detailsscreen.components.DrinkDetailsContent
import com.example.drinkrecipes.presentation.ui.detailsscreen.components.DrinkDetailsTopBar
import com.example.drinkrecipes.presentation.ui.theme.DrinkRecipesTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DrinkDetailsScreen(
    navigateBack: () -> Unit
) {
    DrinkRecipesTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = {
                    DrinkDetailsTopBar(navigateBack)
                }
            ) {
                DrinkDetailsContent()
            }
        }
    }
}
