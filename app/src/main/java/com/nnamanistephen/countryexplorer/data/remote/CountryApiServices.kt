package com.nnamanistephen.countryexplorer.data.remote

import com.nnamanistephen.countryexplorer.data.model.CountryDto
import retrofit2.http.GET

interface CountryApiServices {
    @GET("v3.1/all?fields=name,flags,cca2,region,subregion,capital,population,area,languages")
    suspend fun getAllCountries(): List<CountryDto>

}
