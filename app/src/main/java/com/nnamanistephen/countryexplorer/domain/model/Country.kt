package com.nnamanistephen.countryexplorer.domain.model

data class Country(
    val name: String,
    val officialName: String,
    val code: String,
    val subregion: String?,
    val continent: String,
    val flagUrl: String,
    val capital: String,
    val population: Long,
    val area: Double,
    val languages: List<String>
)
