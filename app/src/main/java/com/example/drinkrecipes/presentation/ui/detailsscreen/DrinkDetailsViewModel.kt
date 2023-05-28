package com.example.drinkrecipes.presentation.ui.detailsscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.drinkrecipes.domain.usecase.GetDrinkDetailsUsecase
import com.example.drinkrecipes.presentation.mapper.toDrinkDetailsViewData
import com.example.drinkrecipes.presentation.model.DrinkDetailsViewData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class DrinkDetailsViewModel @Inject constructor(
    getDrinkDetailsUsecase: GetDrinkDetailsUsecase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val id = checkNotNull(savedStateHandle["id"]).toString()

    val details: Flow<DrinkDetailsViewData?> =
        getDrinkDetailsUsecase(id).map {
            it?.toDrinkDetailsViewData()
        }
}
