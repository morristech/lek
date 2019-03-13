package com.stavro_xhardha.lek.di

import android.content.Context
import androidx.room.Room
import com.stavro_xhardha.lek.AppScope
import com.stavro_xhardha.lek.room.LekDatabase
import dagger.Module
import dagger.Provides

@Module(includes = [AppContextModule::class])
class DatabaseModule {

    @Provides
    @AppScope
    fun provideApplicationDatabaseInstance(application: Context): LekDatabase =
        Room.databaseBuilder(application, LekDatabase::class.java, "lek_db")
            .fallbackToDestructiveMigration().build()
}