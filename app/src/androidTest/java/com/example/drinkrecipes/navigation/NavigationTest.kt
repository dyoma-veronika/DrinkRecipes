package com.example.drinkrecipes.navigation

import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.drinkrecipes.presentation.ui.MainActivity
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
@HiltAndroidTest
class NavigationTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.activity.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            NavGraph(navController = navController)
        }
    }

    @Test
    fun appNavHost_verifyStartDestination() = runBlockingTest {
        composeTestRule.waitForIdle()

        val startDestination = navController.graph.startDestinationRoute
        val currentDestination = navController.currentBackStackEntry?.destination?.route

        assertThat(currentDestination).isEqualTo(startDestination)
    }

    @Test
    fun navigateToDetailsScreen() = runBlockingTest {

        val drinkCardNode = composeTestRule
            .onNodeWithText("1-900-FUK-MEUP")

        drinkCardNode.performClick()

        composeTestRule.waitForIdle()

        val currentDestination = navController.currentBackStackEntry?.destination?.route
        val expectedDestination = Screen.DetailsScreen.route + "/{id}"

        assertThat(currentDestination).isEqualTo(expectedDestination)
    }
}
