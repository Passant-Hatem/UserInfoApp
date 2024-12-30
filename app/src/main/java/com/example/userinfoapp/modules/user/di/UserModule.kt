package com.example.userinfoapp.modules.user.di

import com.example.userinfoapp.modules.user.data.DefaultUserRepository
import com.example.userinfoapp.modules.user.data.UserDatabase
import com.example.userinfoapp.modules.user.domain.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object UserModule {
    @Provides
    @ActivityRetainedScoped
    fun provideUserRepository(database: UserDatabase): UserRepository {
        return DefaultUserRepository(database.userDao())
    }
}