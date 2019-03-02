package com.stavro_xhardha.lek.network

import com.stavro_xhardha.lek.CURRENCY_ACCESS_TOKEN_KEY
import com.stavro_xhardha.lek.model.Currency
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    @GET("latest")
    fun getLatestCurrencies(@Query(CURRENCY_ACCESS_TOKEN_KEY) token: String): Deferred<Currency>
}