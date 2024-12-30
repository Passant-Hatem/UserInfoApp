package com.example.userinfoapp.modules.user.data

import com.example.userinfoapp.modules.user.domain.UserRepository
import com.example.userinfoapp.modules.user.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(
    private val database: UserDao
) : UserRepository {
    override fun getUser(id: Int): Flow<User?> = database.getUser(id)
    override fun saveUser(user: User): Long = database.saveUser(user)
}