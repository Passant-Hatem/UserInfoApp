package com.example.userinfoapp.modules.user.domain

import com.example.userinfoapp.modules.user.domain.model.User
import javax.inject.Inject

class SaveUserData @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User) = userRepository.saveUser(user)
}