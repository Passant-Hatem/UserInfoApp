package com.example.userinfoapp.modules.user.presentaion.create_user_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateUserProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Box(Modifier.fillMaxSize()){
                    Button(
                        onClick = { onNavigateToUserProfile(9L) },
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Text(text = "onNavigate")
                    }
                }
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