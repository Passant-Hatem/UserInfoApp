package com.example.userinfoapp.modules.user.user_profile.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.userinfoapp.R
import com.example.userinfoapp.modules.core.mics.Action
import com.example.userinfoapp.modules.user.domain.model.User

@Composable
fun UserScreenContent(user: User, onNavigateBack: Action) = with(user) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.user_data_title),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        UserCard(user)
        Button(
            onClick = onNavigateBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.navigate_back))
        }
    }
}


@Composable
fun ErrorScreen(
    errorMsg: String,
    onRetryClicked: Action
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = errorMsg,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            color = Color.Red,
            modifier = Modifier.padding(all = 18.dp)
        )

        Text(
            text = stringResource(R.string.retry_label),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            style = TextStyle(textDecoration = TextDecoration.Underline),
            modifier = Modifier.clickable { onRetryClicked() }
        )

    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

