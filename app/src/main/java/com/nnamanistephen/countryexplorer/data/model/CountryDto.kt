package com.nnamanistephen.countryexplorer.data.model

import com.google.gson.annotations.SerializedName


data class CountryDto (
    @SerializedName("name") val name: NameDto,
    @SerializedName("cca2") val countryCode: String,
    @SerializedName("region") val region: String,
    @SerializedName("subregion") val subregion: String,
    @SerializedName("flags") val flags: FlagDto,
    @SerializedName("capital") val capital: List<String>?,
    @SerializedName("population") val population: Long,
    @SerializedName("area") val area: Double,
    @SerializedName("languages") val languages: Map<String, String>?
){
    data class FlagDto(
        @SerializedName("png") val png: String,
        @SerializedName("svg") val svg: String
    )


    data class NameDto (
        @SerializedName("common") val common: String,
        @SerializedName("official") val official: String
    )
}


