package com.stavro_xhardha.lek.model.dbmodels

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LatestCurrenciesDao {
    @Query("Select * from latest_currencies")
    fun getAllLatestCurrencies(): LiveData<List<LatestCurrency>>

    @Insert
    fun insertCurrency(latestCurrency: LatestCurrency)

    @Query("Update latest_currencies set rating = :rating where id = :currencyId")
    fun updateCurrencyRating(currencyId: Int, rating: Double)
}