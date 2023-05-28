package com.example.drinkrecipes.di


import com.example.drinkrecipes.domain.repository.DrinksRepository
import com.example.drinkrecipes.domain.usecase.GetAllDrinksUsecase
import com.example.drinkrecipes.domain.usecase.GetDrinkDetailsUsecase
import com.example.drinkrecipes.domain.usecase.RefreshAllDrinksUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    fun providesGetAllDrinksUsecase(
        drinksRepository: DrinksRepository
    ): GetAllDrinksUsecase {
        return GetAllDrinksUsecase(drinksRepository)
    }

    @Provides
    fun providesRefreshAllDrinksUsecase(
        drinksRepository: DrinksRepository
    ): RefreshAllDrinksUsecase {
        return RefreshAllDrinksUsecase(drinksRepository)
    }

    @Provides
    fun providesGetDrinkDetailsUsecase(
        drinksRepository: DrinksRepository
    ): GetDrinkDetailsUsecase {
        return GetDrinkDetailsUsecase(drinksRepository)
    }
}
