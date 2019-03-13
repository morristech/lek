package com.stavro_xhardha.lek.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stavro_xhardha.lek.repository.CurrencyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class HomeViewModel(repository: CurrencyRepository) : ViewModel() {

    val _progressBar: MutableLiveData<Int> = MutableLiveData()

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    init {
        startCurrenciesCall()
    }

    private fun startCurrenciesCall() {

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
