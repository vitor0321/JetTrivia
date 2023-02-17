package com.walcker.jettrivia.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walcker.jettrivia.presentation.theme.mLightBlue
import com.walcker.jettrivia.presentation.theme.mOffWhite

@Preview
@Composable
fun ButtonTrivia(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: Color = mLightBlue,
    text: String = "txt",
    onNextClicked: () -> Unit = {}
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(3.dp),
        enabled = enabled,
        onClick = { onNextClicked() },
        shape = RoundedCornerShape(34.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color
        )
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = text,
            color = mOffWhite,
            fontSize = 17.sp
        )
    }
}