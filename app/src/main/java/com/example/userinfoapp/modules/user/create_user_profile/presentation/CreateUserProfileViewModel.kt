package com.example.userinfoapp.modules.user.create_user_profile.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userinfoapp.R
import com.example.userinfoapp.modules.user.presentation.model.ActionStates
import com.example.userinfoapp.modules.user.domain.SaveUserData
import com.example.userinfoapp.modules.user.domain.model.Gender
import com.example.userinfoapp.modules.user.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CreateUserProfileViewModel @Inject constructor(
    private val saveUserData: SaveUserData
) : ViewModel() {
    private val _state = mutableStateOf(UserFormUIState())
    val state: State<UserFormUIState> = _state

    fun updateNameValue(value: TextFieldValue) {
        _state.value = _state.value.copy(
            name = value,
            nameError = if (value.text.isNotBlank() && !value.text.matches("^[a-zA-Z -]+$".toRegex())) {
                R.string.text_error_message
            } else null
        )
    }

    fun updateAgeValue(value: TextFieldValue) {
        _state.value = _state.value.copy(
            age = value,
            ageError = if (value.text.isNotBlank()) {
                value.text.toIntOrNull()?.let {
                    if (it !in 21..80) R.string.age_error_message else null
                }
            } else null
        )
    }

    fun updateJobTitleValue(value: TextFieldValue) {
        _state.value = _state.value.copy(
            jobTitle = value,
            jobTitleError = if (value.text.isNotBlank() && !value.text.matches("^[a-zA-Z -]+$".toRegex())) {
                R.string.text_error_message
            } else null
        )
    }

    fun updateGenderValue(gender: Gender) {
        _state.value = _state.value.copy(gender = gender)
    }

    fun onSaveClicked() {
        _state.value = _state.value.copy(saveUserDataAction = ActionStates.LOADING)
        val user = User(
            name = _state.value.name.text,
            jobTitle = _state.value.jobTitle.text,
            age = _state.value.age.text.toInt(),
            gender = _state.value.gender.value,
        )
        saveUserData(user).onEach {
            _state.value = _state.value.copy(
                userId = it.getOrNull(),
                saveUserDataAction = ActionStates.SUCCESS
            )
        }.catch {
            _state.value = _state.value.copy(
                errorMsg = R.string.general_error_message,
                saveUserDataAction = ActionStates.ERROR
            )
        }.launchIn(viewModelScope)
    }

    fun resetState() {
        _state.value = UserFormUIState()
    }
}

data class UserFormUIState(
    val userId: Long? = null,
    val name: TextFieldValue = TextFieldValue(),
    val nameError: Int? = null,
    val age: TextFieldValue = TextFieldValue(),
    val ageError: Int? = null,
    val jobTitle: TextFieldValue = TextFieldValue(),
    val jobTitleError: Int? = null,
    val gender: Gender = Gender.None,
    val errorMsg: Int? = null,
    val saveUserDataAction: ActionStates? = null
)