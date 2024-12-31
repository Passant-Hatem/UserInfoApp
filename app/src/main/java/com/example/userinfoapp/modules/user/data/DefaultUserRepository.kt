package com.example.userinfoapp.modules.user.data

import com.example.userinfoapp.modules.user.data.model.UserEntity
import com.example.userinfoapp.modules.user.domain.UserRepository
import com.example.userinfoapp.modules.user.domain.model.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(
    private val database: UserDao
) : UserRepository {
    override fun getUser(id: Int): Flow<UserEntity?> = database.getUser(id)
    override suspend fun saveUser(user: User): Long {
        return database.saveUser(user)
    }
}