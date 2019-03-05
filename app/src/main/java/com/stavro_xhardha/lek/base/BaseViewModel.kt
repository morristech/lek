package com.stavro_xhardha.lek.base

import androidx.lifecycle.ViewModel
import com.stavro_xhardha.lek.di.DaggerViewModelInjector
import com.stavro_xhardha.lek.di.NetworkModule
import com.stavro_xhardha.lek.ui.CurrencyViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector = DaggerViewModelInjector.builder().networkModule(NetworkModule).build()

    init {
        when (this) {
            is CurrencyViewModel -> injector.inject(this)
        }
    }
}
