package com.stavro_xhardha.lek.ui.home

import com.stavro_xhardha.lek.network.CurrencyApi
import com.stavro_xhardha.lek.repository.CurrencyRepository
import com.stavro_xhardha.lek.room.LekDatabase
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    fun provideHomeViewModelFactory(repository: CurrencyRepository) = HomeViewModelFactory(repository)

    @Provides
    fun provideRepository(database: LekDatabase, currencyApi: CurrencyApi) = CurrencyRepository(database, currencyApi)
}