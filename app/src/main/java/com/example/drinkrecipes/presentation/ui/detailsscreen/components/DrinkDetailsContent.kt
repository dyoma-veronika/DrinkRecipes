package com.example.drinkrecipes.presentation.ui.detailsscreen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.drinkrecipes.presentation.ui.detailsscreen.DrinkDetailsViewModel
import kotlinx.coroutines.delay

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DrinkDetailsContent(
    viewModel: DrinkDetailsViewModel = hiltViewModel()
) {

    val details by viewModel.details.collectAsState(null)
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(details) {
        delay(3000)
        if (details == null) {
            snackbarHostState.showSnackbar("No internet")
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                DrinkDetailsCard(drink = details)
            }
        }
    )
}
