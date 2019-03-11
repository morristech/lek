package com.stavro_xhardha.lek.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    //private val injector = DaggerLekAppComponent.builder().networkModule(NetworkModule).build()

    init {
        when (this) {
            //is CurrencyViewModel -> injector.inject(this)
        }
    }
}
