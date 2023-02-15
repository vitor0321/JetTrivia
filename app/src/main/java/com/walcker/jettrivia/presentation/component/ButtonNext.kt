package com.walcker.jettrivia.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walcker.jettrivia.presentation.theme.mLightBlue
import com.walcker.jettrivia.presentation.theme.mOffWhite

@Composable
fun ButtonNext(
    onNextClicked: () -> Unit
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(3.dp),
        onClick = { onNextClicked() },
        shape = RoundedCornerShape(34.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = mLightBlue
        )
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = "Next",
            color = mOffWhite,
            fontSize = 17.sp
        )
    }
}