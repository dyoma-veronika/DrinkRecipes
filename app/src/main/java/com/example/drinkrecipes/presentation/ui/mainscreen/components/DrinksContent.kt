package com.example.drinkrecipes.presentation.ui.mainscreen.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.drinkrecipes.presentation.model.DrinkViewData
import com.example.drinkrecipes.presentation.ui.theme.DrinkRecipesTheme
import com.example.drinkrecipes.presentation.ui.mainscreen.DrinksViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay

@SuppressLint("SuspiciousIndentation")
@Composable
fun DrinksContent(
    padding: PaddingValues,
    viewModel: DrinksViewModel = hiltViewModel(),
    navigateToDetailsScreen: (id: String) -> Unit
) {
    val drinks: List<DrinkViewData> by viewModel.drinks.collectAsState(emptyList())
    val isLoading by viewModel.isLoading.collectAsState()
    val isSuccess by viewModel.isSuccess.collectAsState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isLoading)
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(isSuccess) {
        if (!isSuccess) {
            viewModel.fetchData()
        }
    }

    LaunchedEffect(drinks) {
        delay(3000)
        if (drinks.isEmpty()) {
            snackbarHostState.showSnackbar("No internet")
        }
    }

    DrinkRecipesTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = { SnackbarHost(snackbarHostState) },
            content = {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SwipeRefresh(state = swipeRefreshState, onRefresh = { viewModel.fetchData() }) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                        ) {
                            items(
                                items = drinks)
                            { drink ->
                                DrinkCard(
                                    drink = drink,
                                    onItemClick = {
                                        navigateToDetailsScreen(drink.id)
                                    })
                            }
                        }
                    }
                }
            }
        )
    }
}

