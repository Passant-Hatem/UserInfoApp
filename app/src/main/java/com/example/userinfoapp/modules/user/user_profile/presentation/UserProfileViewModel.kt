package com.example.userinfoapp.modules.user.user_profile.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userinfoapp.modules.user.data.model.toDomain
import com.example.userinfoapp.modules.user.domain.GetUserData
import com.example.userinfoapp.modules.user.domain.model.User
import com.example.userinfoapp.modules.user.presentation.model.ActionStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getData: GetUserData
) : ViewModel() {
    private val _state = mutableStateOf(UserProfileUIState())
    val state: State<UserProfileUIState> = _state

    init {
        val id = savedStateHandle.get<Long>("id")
        _state.value = state.value.copy(id = id)

        getUserData()
    }

    fun getUserData() {
        _state.value = state.value.copy(actionStates = ActionStates.LOADING)
        getData(_state.value.id!!.toInt()).onEach {
            _state.value = state.value.copy(
                user = it?.toDomain(),
                actionStates = ActionStates.SUCCESS
            )
        }.catch {
            _state.value = state.value.copy(actionStates = ActionStates.ERROR)
        }.launchIn(viewModelScope)
    }

}

data class UserProfileUIState(
    val id: Long? = null,
    val user: User? = null,
    val actionStates: ActionStates? = null,
)