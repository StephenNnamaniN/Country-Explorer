package com.nnamanistephen.countryexplorer.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "countries")
data class CountryEntity(
    @PrimaryKey
    @ColumnInfo(name = "countryCode")
    val countryCode: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "officialName")
    val officialName: String,

    @ColumnInfo(name = "continent")
    val continent: String,

    @ColumnInfo(name = "subregion")
    val subregion: String?,

    @ColumnInfo(name = "flagPng")
    val flagPng: String,

    @ColumnInfo(name = "flagSvg")
    val flagSvg: String,


    @ColumnInfo(name = "capital")
    val capital: String?,

    @ColumnInfo(name = "population")
    val population: Long,

    @ColumnInfo(name = "area")
    val area: Double,

    @ColumnInfo(name = "languages")
    val languages: String,
)
