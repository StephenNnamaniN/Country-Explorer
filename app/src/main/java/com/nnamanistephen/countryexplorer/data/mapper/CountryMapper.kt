package com.nnamanistephen.countryexplorer.data.mapper

import com.nnamanistephen.countryexplorer.data.mapper.CountryMapper.toCountry
import com.nnamanistephen.countryexplorer.data.mapper.CountryMapper.toCountryEntity
import com.nnamanistephen.countryexplorer.data.model.CountryDto
import com.nnamanistephen.countryexplorer.data.model.CountryEntity
import com.nnamanistephen.countryexplorer.domain.model.Country

object CountryMapper {
    // DTO to Entity
    fun CountryDto.toCountryEntity(): CountryEntity {
        return CountryEntity(
            countryCode = countryCode,
            name = name.common,
            officialName = name.official,
            continent = region,
            subregion = subregion,
            flagPng = flags.png,
            flagSvg = flags.svg,
            capital = capital?.joinToString(","),
            population = population,
            area = area,
            languages = languages?.values?.joinToString(",") ?: ""
        )
    }

    // Entity to Domain
    fun CountryEntity.toCountry(): Country {
        return Country(
            name = name,
            code = countryCode,
            continent = continent,
            flagUrl = flagPng,
            capital = capital ?: "N/A",
            population = population,
            area = area,
            languages = languages.split(","),
            officialName = officialName,
            subregion = subregion ?: "N/A"
        )
    }

    //DTO to Domain
    fun CountryDto.toCountry(): Country {
        return Country(
            name = name.common,
            code = countryCode,
            continent = region,
            flagUrl = flags.png,
            capital = capital?.joinToString(",") ?: "N/A",
            population = population,
            area = area,
            languages = languages?.values?.toList() ?: emptyList(),
            officialName = name.official,
            subregion = subregion
        )
    }
}

// Extension functions for list mapping
fun List<CountryDto>.toCountryEntityList() = map { it.toCountryEntity() }
fun List<CountryEntity>.toCountryList() = map { it.toCountry() }