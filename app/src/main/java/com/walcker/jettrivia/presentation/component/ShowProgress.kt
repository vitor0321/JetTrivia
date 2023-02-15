package com.walcker.jettrivia.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.walcker.jettrivia.presentation.theme.mDarkPurple
import com.walcker.jettrivia.presentation.theme.mLightPurple
import com.walcker.jettrivia.presentation.theme.mOffWhite

@Composable
fun ShowProgress(
    score: Int,
    listQuestionSize: Int
) {

    val gradient = Brush.linearGradient(
        listOf(
            Color(0xFF9F5075),
            Color(0xFFBE6BE5)
        )
    )

    val percentageOfList = (score / listQuestionSize)
    val progressFactor = remember(score) { mutableStateOf(percentageOfList) }

    Row(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .height(45.dp)
            .border(
                width = 4.dp,
                brush = Brush.linearGradient(
                    colors = listOf(mLightPurple, mDarkPurple)
                ),
                shape = RoundedCornerShape(34.dp)
            )
            .clip(
                RoundedCornerShape(
                    topEndPercent = 50,
                    bottomStartPercent = 50,
                    topStartPercent = 50,
                    bottomEndPercent = 50
                )
            )
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth(progressFactor.value.toFloat())
                .background(brush = gradient),
            enabled = false,
            elevation = null,
            colors = buttonColors(
                backgroundColor = Color.Transparent,
                disabledBackgroundColor = Color.Transparent
            ),
            contentPadding = PaddingValues(1.dp),
            onClick = { }) {
        }
    }
}