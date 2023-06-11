package com.example.drinkrecipes.presentation.ui.detailsscreen

import androidx.lifecycle.SavedStateHandle
import com.example.drinkrecipes.data.repository.FakeDrinksRepositoryImpl
import com.example.drinkrecipes.domain.usecase.GetDrinkDetailsUsecase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat

class DrinkDetailsViewModelTest {

    private lateinit var viewModel: DrinkDetailsViewModel
    private val getDrinkDetailsUsecase = GetDrinkDetailsUsecase(FakeDrinksRepositoryImpl())
    private val savedStateHandle = SavedStateHandle()

    @Before
    fun setup() {
        savedStateHandle["id"] = "1"
        viewModel = DrinkDetailsViewModel(getDrinkDetailsUsecase, savedStateHandle)
    }

    @Test
    fun `details is not empty` () = runBlockingTest {
        val details = viewModel.details.first()

        assertThat(details).isNotNull()
    }
}
