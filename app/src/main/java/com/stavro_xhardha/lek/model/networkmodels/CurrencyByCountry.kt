package com.stavro_xhardha.lek.model.networkmodels

import com.google.gson.annotations.SerializedName

data class CurrencyByCountry(
    @SerializedName("code")
    val code: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("symbol")
    val symbol: String
)
