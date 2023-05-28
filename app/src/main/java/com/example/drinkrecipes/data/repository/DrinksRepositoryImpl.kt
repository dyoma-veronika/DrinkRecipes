package com.example.drinkrecipes.data.repository

import com.example.drinkrecipes.data.local.db.DrinksDatabase
import com.example.drinkrecipes.data.local.mapper.toDrinkData
import com.example.drinkrecipes.data.local.mapper.toDrinkDetailsData
import com.example.drinkrecipes.data.local.mapper.toDrinkDetailsEntity
import com.example.drinkrecipes.data.local.mapper.toDrinkEntity
import com.example.drinkrecipes.domain.model.DrinkData
import com.example.drinkrecipes.domain.model.DrinkDetailsData
import com.example.drinkrecipes.domain.repository.DrinksRepository
import com.example.drinkrecipes.domain.service.NetworkService
import com.example.drinkrecipes.util.network.LoadingState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DrinksRepositoryImpl @Inject constructor(
    private val networkService: NetworkService,
    database: DrinksDatabase
) : DrinksRepository {

    private val drinksDao = database.drinksDao()

    override fun updateData(): Flow<LoadingState> = flow {
        emit(LoadingState.Loading)
        val drinkData = networkService.getAllDrinks()
        drinkData.data?.let { drinks ->
            drinksDao.insertAllDrinks(drinks.map { it.toDrinkEntity() })
        }
        emit(drinkData.loadingState)
    }

    override fun getDrinks(): Flow<List<DrinkData>> =
        drinksDao.getAllDrinks().distinctUntilChanged()
            .map { list -> list.map { it.toDrinkData() } }

    override fun getDrinkDetails(id: String): Flow<DrinkDetailsData?> = flow {
        val entity = drinksDao.getDrinkById(id)
        if (entity != null) {
            emit(entity.toDrinkDetailsData())
        } else {
            val drinkDetailsData = networkService.getDrinkById(id).data
            drinkDetailsData?.let {
                drinksDao.insertDrink(it.toDrinkDetailsEntity())
            }
            emit(drinkDetailsData)
        }
    }
}
