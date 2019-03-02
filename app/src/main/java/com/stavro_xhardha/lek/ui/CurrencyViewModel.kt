package com.stavro_xhardha.lek.ui

import android.util.Log
import com.stavro_xhardha.lek.CURRENCY_ACCESS_TOKEN
import com.stavro_xhardha.lek.base.BaseViewModel
import com.stavro_xhardha.lek.network.CurrencyApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class CurrencyViewModel : BaseViewModel() {
    @Inject
    lateinit var currencyApi: CurrencyApi

    init {
        loadCurrencies()
    }

    private fun loadCurrencies() {
        GlobalScope.launch {
            val request = currencyApi.getLatestCurrenciesAsync(CURRENCY_ACCESS_TOKEN)
            try {
                val response = request.await()
                Log.d("beni", response.success.toString())
            } catch (e: HttpException) {
                e.printStackTrace()
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}