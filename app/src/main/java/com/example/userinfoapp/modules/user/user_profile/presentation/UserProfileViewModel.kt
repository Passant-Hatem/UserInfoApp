package com.example.userinfoapp.modules.user.user_profile.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.userinfoapp.modules.user.domain.GetUserData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getUserData: GetUserData
): ViewModel() {
    private val _state = mutableStateOf(UserProfileUIModel())
    val state: State<UserProfileUIModel> = _state

    init {
        val id = savedStateHandle.get<Long>("id")
        _state.value = state.value.copy(id = id)
    }

}

data class UserProfileUIModel(
    val id: Long? = null
)