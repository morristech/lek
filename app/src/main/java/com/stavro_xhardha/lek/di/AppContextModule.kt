package com.stavro_xhardha.lek.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppContextModule(private val context: Context) {

    @Provides
    fun provideApplicationContext(): Context = context

}