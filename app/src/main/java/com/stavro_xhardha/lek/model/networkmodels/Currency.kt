package com.stavro_xhardha.lek.model.networkmodels

import com.google.gson.annotations.SerializedName

data class Currency(

    @SerializedName("date")
    val date: String? = null,

    @SerializedName("success")
    val success: Boolean? = null,

    @SerializedName("rates")
    val rates: Rates? = null,

    @SerializedName("timestamp")
    val timestamp: Int? = null,

    @SerializedName("base")
    val base: String? = null
)