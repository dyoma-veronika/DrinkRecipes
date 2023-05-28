package com.example.drinkrecipes.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "drinks_details")
data class DrinkDetailsEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image_uri")
    val imageUri: String,
    @ColumnInfo(name = "ingredients")
    val ingredients: List<String?>,
    @ColumnInfo(name = "instructions")
    val instructions: String?,
    @ColumnInfo(name = "instructions_de")
    val instructionsDe: String?,
    @ColumnInfo(name = "instructions_es")
    val instructionsEs: String?,
    @ColumnInfo(name = "instructions_fr")
    val instructionsFr: String?,
    @ColumnInfo(name = "instructions_it")
    val instructionsIt: String?,
    @ColumnInfo(name = "instructions_zh_hans")
    val instructionsZhHans: String?,
    @ColumnInfo(name = "instructions_zh_hant")
    val instructionsZhHant: String?
)
