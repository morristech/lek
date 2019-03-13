package com.stavro_xhardha.lek

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.stavro_xhardha.lek.di.AppContextModule
import com.stavro_xhardha.lek.di.DaggerLekAppComponent
import com.stavro_xhardha.lek.di.LekAppComponent

class LekApplication : Application() {

    private lateinit var appComponent: LekAppComponent

    companion object {
        fun instance(activity: FragmentActivity): LekApplication = activity.application as LekApplication
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerLekAppComponent.builder().appContextModule(AppContextModule(this)).build()
    }

    fun getAppComponent(): LekAppComponent = appComponent
}