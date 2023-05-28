package com.example.drinkrecipes.presentation.ui.mainscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drinkrecipes.domain.usecase.GetAllDrinksUsecase
import com.example.drinkrecipes.domain.usecase.RefreshAllDrinksUsecase
import com.example.drinkrecipes.presentation.mapper.toDrinkViewData
import com.example.drinkrecipes.presentation.model.DrinkViewData
import com.example.drinkrecipes.util.network.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinksViewModel @Inject constructor(
    getAllDrinksUsecase: GetAllDrinksUsecase,
    private val refreshAllDrinksUsecase: RefreshAllDrinksUsecase
) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess = _isSuccess.asStateFlow()

    fun fetchData() {
        viewModelScope.launch {
        _isLoading.value = true
        refreshAllDrinksUsecase().collect{
            if (it is LoadingState.Success) {
                _isSuccess.value = true
            }
        }
        _isLoading.value = false
    }}

    val drinks: Flow<List<DrinkViewData>> =
        getAllDrinksUsecase().map { list ->
            list.map {
                it.toDrinkViewData()
            }
        }
}
