package com.nnamanistephen.countryexplorer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nnamanistephen.countryexplorer.data.model.CountryEntity

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: List<CountryEntity>)

    @Query("SELECT * FROM countries")
    suspend fun getAllCountries(): List<CountryEntity>

    @Query("SELECT * FROM countries WHERE countryCode = :code")
    suspend fun getCountryByCode(code: String): CountryEntity?
}
