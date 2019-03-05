package com.stavro_xhardha.lek.model.dbmodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "latest_currencies")
data class LatestCurrency(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "currency_code")
    val currencyCode: String,

    @ColumnInfo(name = "currency_name")
    val currencyName: String,


    @ColumnInfo(name = "country_flag")
    val countryFlag: String,

    @ColumnInfo(name = "rating")
    val rating: Double,

    @ColumnInfo(name = "base_currency")
    val base: String
)