package com.example.userinfoapp.modules.user.user_profile.presentation.model

import com.example.userinfoapp.modules.user.domain.model.User
import com.example.userinfoapp.modules.user.presentation.model.ActionStates
import com.example.userinfoapp.modules.user.presentation.model.ScreenState
import com.example.userinfoapp.modules.user.user_profile.presentation.UserProfileUIState

data class UserProfileUIModel(
    val user: User?,
    val screenState: ScreenState
)

fun UserProfileUIState.toUIModel(): UserProfileUIModel {
    return UserProfileUIModel(
        user = user,
        screenState = when  {
            actionStates == ActionStates.LOADING -> ScreenState.Loading
            actionStates == ActionStates.SUCCESS && user != null -> ScreenState.Content
            actionStates == ActionStates.ERROR || user == null -> ScreenState.Error
            else -> ScreenState.Error
        }
    )
}
