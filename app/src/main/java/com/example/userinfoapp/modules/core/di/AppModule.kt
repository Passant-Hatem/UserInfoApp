package com.example.userinfoapp.modules.core.di

import android.app.Application
import androidx.room.Room
import com.example.userinfoapp.modules.user.data.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUserDatabase(application: Application): UserDatabase {
        return Room.databaseBuilder(
            application,
            UserDatabase::class.java,
            UserDatabase.DATABASE_NAME
        ).build()
    }
}