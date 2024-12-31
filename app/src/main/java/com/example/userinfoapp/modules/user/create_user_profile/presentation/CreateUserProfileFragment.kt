package com.example.userinfoapp.modules.user.create_user_profile.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.userinfoapp.modules.user.create_user_profile.presentation.model.toUIModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateUserProfileFragment : Fragment() {
    private val viewModel: CreateUserProfileViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val state = viewModel.state.value
                state.errorMsg?.let {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
                }
                UserFormScreen(
                    uiModel = state.toUIModel(),
                    onUpdateNameValue = viewModel::updateNameValue,
                    onUpdateAgeValue = viewModel::updateAgeValue,
                    onUpdateJobTitleValue = viewModel::updateJobTitleValue,
                    onUpdateGenderValue = viewModel::updateGenderValue,
                    onSaveClicked = viewModel::onSaveClicked,
                    onNavigateToUserProfile = {
                        state.userId?.let {
                            onNavigateToUserProfile(state.userId)
                            viewModel.resetState()
                        }
                    }
                )
            }
        }
    }

    private fun onNavigateToUserProfile(id: Long) {
        findNavController().navigate(
            CreateUserProfileFragmentDirections.actionCreateUserProfileFragmentToUserProfileFragment(
                id
            )
        )
    }
}

