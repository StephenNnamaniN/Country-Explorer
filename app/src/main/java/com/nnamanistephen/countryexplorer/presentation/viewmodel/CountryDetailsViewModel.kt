package com.nnamanistephen.countryexplorer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nnamanistephen.countryexplorer.domain.Resource
import com.nnamanistephen.countryexplorer.domain.usecases.GetCountryByCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryDetailsViewModel @Inject constructor(
    private val getCountryByCodeUseCase: GetCountryByCodeUseCase
): ViewModel(){

    private val _state = MutableStateFlow(CountryDetailState())
    val state: StateFlow<CountryDetailState> = _state.asStateFlow()

    fun loadCountry(code: String) {
        viewModelScope.launch {
            getCountryByCodeUseCase(code).collect { result->
                when (result) {
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            country = result.data,
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
}