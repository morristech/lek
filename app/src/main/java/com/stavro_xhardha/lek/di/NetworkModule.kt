package com.stavro_xhardha.lek.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.stavro_xhardha.lek.AppScope
import com.stavro_xhardha.lek.CURRENCY_BASE_URL
import com.stavro_xhardha.lek.network.CurrencyApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {
    @Provides
    @AppScope
    @JvmStatic
    fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi {
        return retrofit.create(CurrencyApi::class.java)
    }

    @Provides
    @AppScope
    @JvmStatic
    fun provideCurrencyRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(CURRENCY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}