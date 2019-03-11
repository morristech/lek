package com.stavro_xhardha.lek.ui.home

import com.stavro_xhardha.lek.di.LekAppComponent
import dagger.Component

@FragmentScope
@Component(modules = [(HomeFragmentModule::class)], dependencies = [(LekAppComponent::class)])
interface HomeComponent {
    fun inject(homeFragment: HomeFragment)
}