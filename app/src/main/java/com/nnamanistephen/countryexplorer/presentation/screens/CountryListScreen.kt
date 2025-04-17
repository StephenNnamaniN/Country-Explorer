package com.nnamanistephen.countryexplorer.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nnamanistephen.countryexplorer.presentation.viewmodel.CountryListViewModel
import com.nnamanistephen.countryexplorer.presentation.component.CountryCard
import com.nnamanistephen.countryexplorer.presentation.component.CountrySearchBar

@Composable
fun CountryListScreen(
    listViewModel: CountryListViewModel = hiltViewModel(),
    onCountryClick: (String) -> Unit
){
    val state by listViewModel.state.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CountrySearchBar(
            query = state.searchQuery,
            onQueryChange = listViewModel::OnSearchQueryChanged,
            placeholder = "Search Country"
        )
        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
            state.error != null -> {
                Text(
                    text = state.error!!,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp)
                )
            }
            state.searchQuery.isNotEmpty() && state.filteredCountries.isEmpty() -> {
                Text(
                    text = "No countries found in the list",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
            else -> {
                val countriesToShow = if (state.searchQuery.isNotEmpty()){
                    state.filteredCountries
                }else {
                    state.countries
                }

                if (countriesToShow.isNotEmpty()) {
                    LazyColumn {
                        items(countriesToShow){ country ->
                            CountryCard(
                                country = country,
                                onClick = {onCountryClick(country.code)}
                            )
                        }
                    }
                }
            }
        }
    }
}
