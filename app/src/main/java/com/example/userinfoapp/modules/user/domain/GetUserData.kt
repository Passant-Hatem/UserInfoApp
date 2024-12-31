package com.example.userinfoapp.modules.user.domain

import javax.inject.Inject

class GetUserData @Inject constructor(
    private val userRepository: UserRepository
){
    operator fun invoke(id: Int) = userRepository.getUser(id)
}