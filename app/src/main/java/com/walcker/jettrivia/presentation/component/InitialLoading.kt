package com.walcker.jettrivia.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.walcker.jettrivia.presentation.theme.mDarkPurple

@Preview
@Composable
fun InitialLoading() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = mDarkPurple
    ) {

        var dialogState by remember { mutableStateOf(false) }
        Dialog(
            onDismissRequest = { dialogState = false },
            DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(100.dp)
                    .background(
                        color = White,
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                Column {
                    CircularProgressIndicator(
                        color = Color.Red,
                        modifier = Modifier.padding(6.dp, 0.dp, 0.dp, 0.dp)
                    )
                    Text(
                        text = "Loading...",
                        modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp)
                    )
                }
            }
        }
    }
}