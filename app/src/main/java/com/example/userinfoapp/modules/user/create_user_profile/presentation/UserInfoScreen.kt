package com.example.userinfoapp.modules.user.create_user_profile.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userinfoapp.R
import com.example.userinfoapp.modules.core.mics.Action
import com.example.userinfoapp.modules.core.mics.Consumer
import com.example.userinfoapp.modules.user.create_user_profile.presentation.components.CustomTextField
import com.example.userinfoapp.modules.user.create_user_profile.presentation.model.UserFormUIModel
import com.example.userinfoapp.modules.user.domain.model.Gender

@Composable
fun UserFormScreen(
    uiModel: UserFormUIModel,
    onUpdateNameValue: Consumer<TextFieldValue>,
    onUpdateAgeValue: Consumer<TextFieldValue>,
    onUpdateJobTitleValue: Consumer<TextFieldValue>,
    onUpdateGenderValue: Consumer<Gender>,
    onSaveClicked: Action,
    onNavigateToUserProfile: Action
) = with(uiModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.form_title),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            value = name,
            onValueChange = onUpdateNameValue,
            enabled = isFormEnabled,
            label = R.string.name,
            error = nameError,
            imeAction = ImeAction.Next
        )
        CustomTextField(
            value = age,
            onValueChange = onUpdateAgeValue,
            enabled = isFormEnabled,
            label = R.string.age,
            error = ageError,
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        )
        CustomTextField(
            value = jobTitle,
            onValueChange = onUpdateJobTitleValue,
            enabled = isFormEnabled,
            label = R.string.job_title,
            error = jobTitleError,
            imeAction = ImeAction.Done
        )
        GenderSelection(gender, isFormEnabled, onUpdateGenderValue)
        Button(
            onClick = onSaveClicked,
            enabled = enableSaveButton,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.save))
        }
        if (showNavigationButton) {
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onNavigateToUserProfile,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.show_profile))
            }
        }
    }
}

@Composable
fun GenderSelection(
    gender: Gender,
    enabled: Boolean,
    onUpdateGenderValue: Consumer<Gender>
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Male Button
        Row(
            modifier = Modifier.clickable { onUpdateGenderValue(Gender.Male) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = gender == Gender.Male,
                enabled = enabled,
                onClick = { onUpdateGenderValue(Gender.Male) }
            )
            Text(text = stringResource(id = R.string.male))
        }

        // Female Button
        Row(
            modifier = Modifier.clickable { onUpdateGenderValue(Gender.Female) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = gender == Gender.Female,
                enabled = enabled,
                onClick = { onUpdateGenderValue(Gender.Female) }
            )
            Text(text = stringResource(id = R.string.female))
        }
    }
}
