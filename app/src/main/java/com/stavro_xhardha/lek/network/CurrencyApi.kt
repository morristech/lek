package com.stavro_xhardha.lek.network

import com.stavro_xhardha.lek.CURRENCY_ACCESS_TOKEN_KEY
import com.stavro_xhardha.lek.model.networkmodels.Country
import com.stavro_xhardha.lek.model.networkmodels.Currency
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface CurrencyApi {
    @GET("latest")
    fun getLatestCurrenciesAsync(@Query(CURRENCY_ACCESS_TOKEN_KEY) token: String): Deferred<Currency>

    @GET
    fun getAllCurrencies(@Url countriesUrl: String): Deferred<Response<List<Country>>>
}