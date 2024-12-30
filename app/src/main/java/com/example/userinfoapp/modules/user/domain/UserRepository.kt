package com.example.userinfoapp.modules.user.domain

import com.example.userinfoapp.modules.user.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(id: Int): Flow<User?>
    fun saveUser(user: User): Long
}