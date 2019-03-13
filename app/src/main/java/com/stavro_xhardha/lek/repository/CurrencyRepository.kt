package com.stavro_xhardha.lek.repository

import com.stavro_xhardha.lek.COUNTRIES_BASE_URL
import com.stavro_xhardha.lek.CURRENCY_ACCESS_TOKEN
import com.stavro_xhardha.lek.model.dbmodels.LatestCurrenciesDao
import com.stavro_xhardha.lek.model.dbmodels.LatestCurrency
import com.stavro_xhardha.lek.model.networkmodels.Country
import com.stavro_xhardha.lek.model.networkmodels.Currency
import com.stavro_xhardha.lek.network.CurrencyApi
import com.stavro_xhardha.lek.room.LekDatabase
import retrofit2.Response
import javax.inject.Inject

class CurrencyRepository @Inject constructor(database: LekDatabase, private val currencyApi: CurrencyApi) {
    private var currenciesDao: LatestCurrenciesDao = database.latestCurrenciesDao()

    suspend fun loadCurrencies(): ArrayList<LatestCurrency> {
        val currenciesRequest = currencyApi.getLatestCurrenciesAsync(CURRENCY_ACCESS_TOKEN)
        val flagsRequest = currencyApi.getAllCurrencies(COUNTRIES_BASE_URL)
        return startDatabaseInsertion(currenciesRequest.await(), flagsRequest.await())
    }

    fun startDatabaseInsertion(
        currency: Currency,
        contriesResponse: Response<List<Country>>
    ): ArrayList<LatestCurrency> {
        if (contriesResponse.isSuccessful) {
            val countries = contriesResponse.body()
            countries!!.forEach {
                it.arrayOfCurrenciesByCountry.forEach {
                    currenciesDao.insertCurrency(
                        LatestCurrency(
                            id = 1,
                            countryFlag = "",
                            currencyCode = it.code,
                            currencyName = it.name,
                            symbol = it.symbol,
                            base = "",
                            rating = 0.0
                        )
                    )
                }
                // todo start here tomorow currenciesDao.updateCurrencyFlag()

            }
        }

        return ArrayList<LatestCurrency>()
    }
}