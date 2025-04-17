package com.nnamanistephen.countryexplorer.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.nnamanistephen.countryexplorer.presentation.viewmodel.CountryDetailsViewModel
import com.nnamanistephen.countryexplorer.presentation.component.CountryDetailContent

@Composable
fun CountryDetailScreen(
    code:  String,
    detailViewModel: CountryDetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = code) {
        detailViewModel.loadCountry(code)
    }
     val state by detailViewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(state.country?.flagUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxSize()
                .blur(16.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.isLoading){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            state.error?.let { error ->
                Text(text = error, color = MaterialTheme.colorScheme.error)
            }

            state.country?.let { country ->
                CountryDetailContent(country = country)
            }

        }
    }
}