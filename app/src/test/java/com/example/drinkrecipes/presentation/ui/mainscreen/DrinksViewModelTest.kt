package com.example.drinkrecipes.presentation.ui.mainscreen

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.drinkrecipes.MainCoroutineRule
import com.example.drinkrecipes.data.repository.FakeDrinksRepositoryImpl
import com.example.drinkrecipes.domain.usecase.GetAllDrinksUsecase
import com.example.drinkrecipes.domain.usecase.RefreshAllDrinksUsecase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

@OptIn(ExperimentalCoroutinesApi::class)
class DrinksViewModelTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: DrinksViewModel
    private val getAllDrinksUsecase = GetAllDrinksUsecase(FakeDrinksRepositoryImpl())
    private val refreshAllDrinksUsecase = RefreshAllDrinksUsecase(FakeDrinksRepositoryImpl())

    @Before
    fun setup() {
        viewModel = DrinksViewModel(getAllDrinksUsecase, refreshAllDrinksUsecase)
    }

    @Test
    fun `drinks list is not empty` () = runBlockingTest {
        val drinks = viewModel.drinks.first()

        assertThat(drinks).isNotEmpty()
    }

    @Test
    fun `isSuccess value is true` () {
        viewModel.fetchData()

        val loadingState = viewModel.isSuccess.value

        assertThat(loadingState).isEqualTo(true)
    }
}
