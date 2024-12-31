package com.example.userinfoapp.modules.user.presentaion.create_user_profile

import androidx.lifecycle.ViewModel
import com.example.userinfoapp.modules.user.domain.SaveUserData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CreateUserProfileViewModel @Inject constructor(
    private val saveUserData: SaveUserData
): ViewModel() {
}