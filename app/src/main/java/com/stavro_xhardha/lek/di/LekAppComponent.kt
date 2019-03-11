package com.stavro_xhardha.lek.di

import com.stavro_xhardha.lek.AppScope
import com.stavro_xhardha.lek.network.CurrencyApi
import com.stavro_xhardha.lek.room.LekDatabase
import dagger.Component

@AppScope
@Component(modules = [(NetworkModule::class), (DatabaseModule::class)])
interface LekAppComponent {

    fun lekDatabase(): LekDatabase

    fun currencyApi(): CurrencyApi
}