package com.example.drinkrecipes.util.network

sealed interface LoadingState {
    object Loading : LoadingState
    object Success : LoadingState
    class Error(val error: NetworkErrors) : LoadingState
}
