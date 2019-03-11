package com.stavro_xhardha.lek.di

import com.stavro_xhardha.lek.AppScope
import com.stavro_xhardha.lek.LekApplication
import dagger.Component

@AppScope
@Component(modules = [(NetworkModule::class), (DatabaseModule::class)])
interface LekAppComponent {
    fun inject(lekApplication: LekApplication)
}