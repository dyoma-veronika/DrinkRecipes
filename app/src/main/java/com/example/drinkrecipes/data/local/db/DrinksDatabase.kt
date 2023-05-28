package com.example.drinkrecipes.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.drinkrecipes.data.local.db.dao.DrinksDao
import com.example.drinkrecipes.data.local.db.entity.Converters
import com.example.drinkrecipes.data.local.db.entity.DrinkDetailsEntity
import com.example.drinkrecipes.data.local.db.entity.DrinkEntity

@Database(entities = [DrinkEntity::class, DrinkDetailsEntity::class], version = 5, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DrinksDatabase : RoomDatabase() {
    abstract fun drinksDao(): DrinksDao
}
