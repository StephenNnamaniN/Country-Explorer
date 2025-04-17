package com.nnamanistephen.countryexplorer.data.remote

import com.nnamanistephen.countryexplorer.data.model.CountryDto
import retrofit2.http.GET

interface CountryApiServices {
    @GET("v3.1/all")
    suspend fun getAllCountries(): List<CountryDto>

}
