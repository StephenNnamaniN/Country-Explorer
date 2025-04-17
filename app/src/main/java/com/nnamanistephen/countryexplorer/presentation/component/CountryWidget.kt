package com.nnamanistephen.countryexplorer.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.nnamanistephen.countryexplorer.domain.model.Country
import java.text.DecimalFormat

@Composable
fun CountryCard(
    country: Country,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(
        modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = country.flagUrl,
                contentDescription = " Flag of ${country.name}",
                modifier
                    .size(52.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier.weight(1f)
            ) {
                Text(
                    text = "${country.name}, ${country.code}",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Capital: ${country.capital}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(0.7f)
                )

                Text(
                    text = "Continent: ${country.continent}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(0.7f)
                )
            }
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "View country detail",
                tint = MaterialTheme.colorScheme.onSurface.copy(0.7f)
            )
        }

    }
}

@Composable
fun CountrySearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    placeholder: String,
){
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        label = { Text(text = placeholder)},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search icon")
        },
        trailingIcon = {
            if (query.isNotEmpty()){
                IconButton(onClick = { onQueryChange("") }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Clear search")
                }
            }
        },
        maxLines = 1,
        singleLine = true,
        shape = RoundedCornerShape(15.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Green,
            cursorColor = Color.Green),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
        )
}

@Composable
fun CountryDetailContent(
    country: Country,
    modifier: Modifier = Modifier
) {
    Column(
        modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = country.flagUrl,
            contentDescription = "Flag of: ${country.name}",
            modifier
                .size(150.dp)
                .clip(MaterialTheme.shapes.large),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(16.dp))

        Card(
            modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(15.dp),
            elevation = CardDefaults.elevatedCardElevation()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                DetailRow(
                    label = "Country Name:",
                    value = country.name
                )
                HorizontalDivider(
                    modifier.padding(top = 3.dp, bottom = 3.dp),
                    thickness = 2.dp
                )
                DetailRow(
                    label = "Official Name:",
                    value = country.officialName
                )
                HorizontalDivider(
                    modifier.padding(top = 3.dp, bottom = 3.dp),
                    thickness = 2.dp
                )
                DetailRow(
                    label = "Capital:",
                    value = country.capital
                )
                HorizontalDivider(
                    modifier.padding(top = 3.dp, bottom = 3.dp),
                    thickness = 2.dp
                )
                DetailRow(
                    label = "Sub-region:",
                    value = country.subregion ?: "N/A"
                )
                HorizontalDivider(
                    modifier.padding(top = 3.dp, bottom = 3.dp),
                    thickness = 2.dp
                )
                DetailRow(
                    label = "Continent:",
                    value = country.continent
                )
                HorizontalDivider(
                    modifier.padding(top = 3.dp, bottom = 3.dp),
                    thickness = 2.dp
                )
                DetailRow(
                    label = "Area:",
                    value = "${DecimalFormat("#,###").format(country.area)} km2"
                )
                HorizontalDivider(
                    modifier.padding(top = 3.dp, bottom = 3.dp),
                    thickness = 2.dp
                )

                DetailRow(
                    label = "Languages:",
                    value = country.languages.joinToString(",")
                )
                HorizontalDivider(
                    modifier.padding(top = 3.dp, bottom = 3.dp),
                    thickness = 2.dp
                )

                DetailRow(
                    label = "Population:",
                    value = country.population.toString()
                )
                HorizontalDivider(
                    modifier.padding(top = 3.dp, bottom = 3.dp),
                    thickness = 2.dp
                )
            }
        }
    }
}

@Composable
fun DetailRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.End,
            maxLines = 2,
            modifier = Modifier.weight(1f, fill = false)
        )

    }
}
