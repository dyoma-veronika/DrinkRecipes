package com.example.drinkrecipes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.drinkrecipes.presentation.ui.detailsscreen.DrinkDetailsScreen
import com.example.drinkrecipes.presentation.ui.mainscreen.DrinksScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {

        composable(Screen.MainScreen.route) {
            DrinksScreen(
                navigateToDetailsScreen = { id ->
                    navController.navigate("${Screen.DetailsScreen.route}/$id")
                }
            )
        }

        composable(
            route = "${Screen.DetailsScreen.route}/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) {
            DrinkDetailsScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
