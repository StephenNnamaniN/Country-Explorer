package com.nnamanistephen.countryexplorer.presentation.viewmodel

import com.nnamanistephen.countryexplorer.domain.model.Country

data class CountryDetailState(
    val country: Country? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
