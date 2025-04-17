package com.nnamanistephen.countryexplorer.data.repository

import com.nnamanistephen.countryexplorer.data.local.CountryDao
import com.nnamanistephen.countryexplorer.data.mapper.CountryMapper.toCountry
import com.nnamanistephen.countryexplorer.data.mapper.toCountryEntityList
import com.nnamanistephen.countryexplorer.data.mapper.toCountryList
import com.nnamanistephen.countryexplorer.data.remote.CountryApiServices
import com.nnamanistephen.countryexplorer.domain.model.Country
import com.nnamanistephen.countryexplorer.domain.repository.CountryRepository
import com.nnamanistephen.countryexplorer.domain.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val apiServices: CountryApiServices,
    private val countryDao: CountryDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): CountryRepository {

    override suspend fun getCountries(): Flow<Resource<List<Country>>>  = flow {
        emit(Resource.Loading())

        // Tries to fetch data from local database
        val localCountries = countryDao.getAllCountries()
        if (localCountries.isNotEmpty()) {
            emit(Resource.Success(localCountries.toCountryList()))
        }

        // Fetch from remote data source
        try {
            val remoteCountries = apiServices.getAllCountries()
            countryDao.insertCountries(remoteCountries.toCountryEntityList())
            emit(Resource.Success(remoteCountries.map { it.toCountry() }))
        }catch (e: Exception){
            emit(Resource.Error("Couldn't load data. ${e.localizedMessage}"))
        }
    }.flowOn(dispatcher)

    override suspend fun getCountryByCode(code: String): Flow<Resource<Country>> = flow<Resource<Country>> {
        emit(Resource.Loading())

        // Tries to country from the local database
        val localCountry = countryDao.getCountryByCode(code)
        if (localCountry != null){
            emit(Resource.Success(localCountry.toCountry()))
        }

        try {
            if (localCountry == null){
                emit(Resource.Error("Country is not found"))
            }
        } catch (e: Exception){
            emit(Resource.Error("Error fetching country. ${e.localizedMessage}"))
        }
    }.flowOn(dispatcher)

}