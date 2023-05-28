package com.example.drinkrecipes.presentation.ui.mainscreen.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.example.drinkrecipes.util.Constants.DRINKS_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinksTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(text = DRINKS_SCREEN)
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}
