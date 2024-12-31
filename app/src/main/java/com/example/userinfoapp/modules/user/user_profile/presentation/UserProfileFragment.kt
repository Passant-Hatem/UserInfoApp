package com.example.userinfoapp.modules.user.user_profile.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.userinfoapp.R
import com.example.userinfoapp.modules.core.mics.Action
import com.example.userinfoapp.modules.user.presentation.model.ActionStates
import com.example.userinfoapp.modules.user.presentation.model.ScreenState
import com.example.userinfoapp.modules.user.user_profile.presentation.components.ErrorScreen
import com.example.userinfoapp.modules.user.user_profile.presentation.components.LoadingScreen
import com.example.userinfoapp.modules.user.user_profile.presentation.components.UserScreenContent
import com.example.userinfoapp.modules.user.user_profile.presentation.model.UserProfileUIModel
import com.example.userinfoapp.modules.user.user_profile.presentation.model.toUIModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserProfileFragment : Fragment() {
    private val viewModel: UserProfileViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val state = viewModel.state.value
                if (state.actionStates == ActionStates.LOADING)
                    LoadingScreen()
                UserProfileScreen(
                    uiModel = state.toUIModel(),
                    onTryAgainClicked = viewModel::getUserData,
                    onNavigateBack = ::navigateBack
                )
            }
        }
    }

    private fun navigateBack() {
        findNavController().popBackStack()
    }
}

@Composable
fun UserProfileScreen(
    uiModel: UserProfileUIModel,
    onTryAgainClicked: Action,
    onNavigateBack: Action
) = with(uiModel) {
    when (screenState) {
        ScreenState.Error -> {
            ErrorScreen(
                errorMsg = stringResource(id = R.string.general_error_message),
                onTryAgainClicked
            )
        }

        ScreenState.Content -> {
            UserScreenContent(user = user!!, onNavigateBack)
        }

        ScreenState.Loading -> {
            LoadingScreen()
        }

    }
}