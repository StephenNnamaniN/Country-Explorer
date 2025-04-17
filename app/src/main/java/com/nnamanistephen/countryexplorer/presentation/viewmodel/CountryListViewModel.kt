package com.nnamanistephen.countryexplorer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nnamanistephen.countryexplorer.domain.Resource
import com.nnamanistephen.countryexplorer.domain.usecases.GetCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CountryListViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
): ViewModel(){

    private val _state = MutableStateFlow(CountryListState())
    val state: StateFlow<CountryListState> = _state.asStateFlow()

    init {
        loadCountries()
    }

    private fun loadCountries() {
        viewModelScope.launch {
            getCountriesUseCase().collect { result ->
                when (result){
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            countries = result.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            error = result.message,
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }

    fun OnSearchQueryChanged(query: String) {
        _state.value = state.value.copy(
            searchQuery = query,
            filteredCountries = if (query.isEmpty()){
                state.value.countries
            } else {
                state.value.countries.filter { country ->
                    country.name.contains(query, ignoreCase = true) ||
                            country.code.contains(query, ignoreCase = true) ||
                            country.continent.contains(query, ignoreCase = true)
                }
            }
        )
    }
}