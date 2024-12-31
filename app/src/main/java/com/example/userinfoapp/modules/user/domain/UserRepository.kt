package com.example.userinfoapp.modules.user.domain

import com.example.userinfoapp.modules.user.data.model.UserEntity
import com.example.userinfoapp.modules.user.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(id: Int): Flow<UserEntity?>
    suspend fun saveUser(user: User): Long
}