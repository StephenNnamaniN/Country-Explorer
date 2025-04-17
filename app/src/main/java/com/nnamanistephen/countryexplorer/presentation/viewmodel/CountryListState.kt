package com.nnamanistephen.countryexplorer.presentation.viewmodel

import com.nnamanistephen.countryexplorer.domain.model.Country

data class CountryListState(
    val countries: List<Country> = emptyList(),
    val filteredCountries: List<Country> = emptyList(),
    val searchQuery: String = "",
    val isLoading: Boolean = false,
    val error: String? = null
)