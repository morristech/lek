package com.stavro_xhardha.lek.ui.main

import android.util.Log
import com.stavro_xhardha.lek.COUNTRIES_BASE_URL
import com.stavro_xhardha.lek.CURRENCY_ACCESS_TOKEN
import com.stavro_xhardha.lek.base.BaseViewModel
import com.stavro_xhardha.lek.model.networkmodels.Country
import com.stavro_xhardha.lek.model.networkmodels.Currency
import com.stavro_xhardha.lek.network.CurrencyApi
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

class CurrencyViewModel : BaseViewModel() {
    @Inject
    lateinit var currencyApi: CurrencyApi

    //todo Inject Repository :)

    init {
        //loadCurrencies()
    }

    private fun loadCurrencies() {
        runBlocking {
            try {
                val currenciesRequest = currencyApi.getLatestCurrenciesAsync(CURRENCY_ACCESS_TOKEN)
                val flagsRequest = currencyApi.getAllCurrencies(COUNTRIES_BASE_URL)
                startDatabaseInsertion(currenciesRequest.await(), flagsRequest.await())
            } catch (e: HttpException) {
                e.printStackTrace()
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }

    private fun startDatabaseInsertion(currency: Currency, contriesResponse: Response<List<Country>>) {
        if (contriesResponse.isSuccessful) {
            val countries = contriesResponse.body()
            countries!!.forEach {
                Log.d("Beni", it.flag)
            }
        }
        Log.d("Beni", currency.base)
    }
}