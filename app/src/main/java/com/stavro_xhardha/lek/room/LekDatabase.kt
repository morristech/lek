package com.stavro_xhardha.lek.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stavro_xhardha.lek.model.dbmodels.LatestCurrenciesDao
import com.stavro_xhardha.lek.model.dbmodels.LatestCurrency

@Database(entities = arrayOf(LatestCurrency::class), version = 1, exportSchema = false)
abstract class LekDatabase : RoomDatabase() {
    abstract fun latestCurrenciesDao(): LatestCurrenciesDao
}