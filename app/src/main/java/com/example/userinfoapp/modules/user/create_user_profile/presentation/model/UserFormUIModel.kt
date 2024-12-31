package com.example.userinfoapp.modules.user.create_user_profile.presentation.model

import androidx.compose.ui.text.input.TextFieldValue
import com.example.userinfoapp.modules.user.create_user_profile.presentation.UserFormUIState
import com.example.userinfoapp.modules.user.domain.model.Gender
import com.example.userinfoapp.modules.user.presentation.model.ActionStates

data class UserFormUIModel(
    val name: TextFieldValue,
    val nameError: Int?,
    val age: TextFieldValue,
    val ageError: Int?,
    val jobTitle: TextFieldValue,
    val jobTitleError: Int?,
    val gender: Gender,
    val isFormEnabled: Boolean,
    val enableSaveButton: Boolean,
    val showNavigationButton: Boolean
)

fun UserFormUIState.toUIModel(): UserFormUIModel = UserFormUIModel(
    name = name,
    nameError = nameError,
    age = age,
    ageError = ageError,
    jobTitle = jobTitle,
    jobTitleError = jobTitleError,
    gender = gender,
    isFormEnabled = saveUserDataAction != ActionStates.SUCCESS,
    enableSaveButton = nameError == null && ageError == null && jobTitleError == null &&
            name.text.isNotBlank() && age.text.isNotBlank() && jobTitle.text.isNotBlank() && gender != Gender.None && saveUserDataAction != ActionStates.SUCCESS,
    showNavigationButton = saveUserDataAction == ActionStates.SUCCESS
)

