package com.stavro_xhardha.lek.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stavro_xhardha.lek.repository.CurrencyRepository

class HomeViewModelFactory(private val repository: CurrencyRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = HomeViewModel(repository) as T

}