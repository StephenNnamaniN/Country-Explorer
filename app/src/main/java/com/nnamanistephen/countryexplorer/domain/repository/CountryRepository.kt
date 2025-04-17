package com.nnamanistephen.countryexplorer.domain.repository

import com.nnamanistephen.countryexplorer.domain.Resource
import com.nnamanistephen.countryexplorer.domain.model.Country
import kotlinx.coroutines.flow.Flow


interface CountryRepository {
    suspend fun getCountries(): Flow<Resource<List<Country>>>
    suspend fun getCountryByCode(code: String): Flow<Resource<Country>>
}