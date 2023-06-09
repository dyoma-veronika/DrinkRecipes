package com.example.drinkrecipes.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.drinkrecipes.data.local.db.DrinksDatabase
import com.example.drinkrecipes.data.local.db.dao.DrinksDao
import com.example.drinkrecipes.data.local.db.entity.DrinkDetailsEntity
import com.example.drinkrecipes.data.local.db.entity.DrinkEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
@OptIn(ExperimentalCoroutinesApi::class)
class DrinksDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: DrinksDatabase
    private lateinit var dao: DrinksDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            DrinksDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.drinksDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertDrink() = runBlockingTest {
        val drink = DrinkDetailsEntity(
            id = "1",
            name = "name",
            imageUri = "uri",
            ingredients = listOf("ingredient1", "ingredient2"),
            instructions = "instructions",
            instructionsDe = "instructionsDe",
            instructionsEs = "instructionsEs",
            instructionsFr = "instructionsFr",
            instructionsIt = "instructionsIt",
            instructionsZhHans = "instructionsZhHans",
            instructionsZhHant = "instructionsZhHant"
        )
        dao.insertDrink(drink)

        val drinkData = dao.getDrinkById("1")

        assertThat(drinkData).isEqualTo(drink)
    }

    @Test
    fun insertAllDrinks() = runBlockingTest {
        val drinks = listOf<DrinkEntity>(
            DrinkEntity("1", "name", "uri"),
            DrinkEntity("2", "name2", "uri2")
        )

        dao.insertAllDrinks(drinks)

        val drinksData = dao.getAllDrinks().first()

        assertThat(drinksData).isEqualTo(drinks)
    }
}
