package com.nnamanistephen.countryexplorer.di

import android.content.Context
import androidx.room.Room
import com.nnamanistephen.countryexplorer.data.local.CountryDao
import com.nnamanistephen.countryexplorer.data.local.CountryDatabase
import com.nnamanistephen.countryexplorer.data.remote.CountryApiServices
import com.nnamanistephen.countryexplorer.data.remote.RetrofitClient
import com.nnamanistephen.countryexplorer.data.repository.CountryRepositoryImpl
import com.nnamanistephen.countryexplorer.domain.repository.CountryRepository
import com.nnamanistephen.countryexplorer.domain.usecases.GetCountriesUseCase
import com.nnamanistephen.countryexplorer.domain.usecases.GetCountryByCodeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCountryApiService(): CountryApiServices {
        return RetrofitClient.create()
    }

    @Provides
    @Singleton
    fun provideCountryDatabase(@ApplicationContext context: Context): CountryDatabase {
        return Room.databaseBuilder(
            context,
            CountryDatabase::class.java,
            "country_db"
        )

            .build()
    }

    @Provides
    @Singleton
    fun provideCountryDao(database: CountryDatabase): CountryDao {
        return database.countryDao()
    }

    @Provides
    @Singleton
    fun provideCountryRepository(
        apiServices: CountryApiServices,
        countryDao: CountryDao,
    ): CountryRepository{
        return CountryRepositoryImpl(apiServices, countryDao)
    }

    @Provides
    fun provideGetCountriesUseCase(repository: CountryRepository): GetCountriesUseCase {
        return GetCountriesUseCase(repository)
    }

    @Provides
    fun provideGetCountryByCodeUseCase(repository: CountryRepository): GetCountryByCodeUseCase {
        return GetCountryByCodeUseCase(repository)
    }

}