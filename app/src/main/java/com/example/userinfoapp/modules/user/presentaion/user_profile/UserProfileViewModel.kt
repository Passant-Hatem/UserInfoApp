package com.example.userinfoapp.modules.user.presentaion.user_profile

import androidx.lifecycle.ViewModel
import com.example.userinfoapp.modules.user.domain.GetUserData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val getUserData: GetUserData
): ViewModel() {
}