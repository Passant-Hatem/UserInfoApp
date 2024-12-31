package com.example.userinfoapp.modules.user.domain

import com.example.userinfoapp.modules.user.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveUserData @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(user: User): Flow<Result<Long>> = flow {
        try {
            val userId = withContext(Dispatchers.IO) {
                userRepository.saveUser(user)
            }
            emit(Result.success(userId))
        } catch (e: Exception) {
            emit(Result.failure(e))
        }
    }
}