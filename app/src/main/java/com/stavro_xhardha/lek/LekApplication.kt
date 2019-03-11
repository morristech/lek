package com.stavro_xhardha.lek

import android.app.Application
import com.stavro_xhardha.lek.di.AppContextModule
import com.stavro_xhardha.lek.di.DaggerLekAppComponent
import com.stavro_xhardha.lek.di.LekAppComponent

class LekApplication : Application() {

    lateinit var appcomponent: LekAppComponent

    override fun onCreate() {
        super.onCreate()
        appcomponent = DaggerLekAppComponent.builder().appContextModule(AppContextModule(this)).build()
    }
}