package com.nnamanistephen.countryexplorer.domain.usecases

import com.nnamanistephen.countryexplorer.domain.model.Country
import com.nnamanistephen.countryexplorer.domain.repository.CountryRepository
import com.nnamanistephen.countryexplorer.domain.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCountryByCodeUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    suspend operator fun invoke(code: String): Flow<Resource<Country>> {
        return repository.getCountryByCode(code)
    }
}