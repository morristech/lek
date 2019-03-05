package com.stavro_xhardha.lek.model.networkmodels

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("flag")
    val flag: String,

    @SerializedName("currencies")
    val arrayOfCurrenciesByCountry: ArrayList<CurrencyByCountry>
)