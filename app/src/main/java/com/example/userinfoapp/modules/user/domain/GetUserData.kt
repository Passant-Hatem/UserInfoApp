package com.example.userinfoapp.modules.user.domain

import com.example.userinfoapp.modules.user.domain.model.User
import javax.inject.Inject

class GetUserData @Inject constructor(
    private val userRepository: UserRepository
){
    operator fun invoke(id: Int) = userRepository.getUser(id)
}