package com.walcker.jettrivia.presentation.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walcker.core.model.QuestionItemUI
import com.walcker.jettrivia.presentation.theme.mOffWhite

@Composable
fun QuestionText(question: QuestionItemUI) {
    Text(
        modifier = Modifier
            .padding(6.dp)
            .fillMaxHeight(0.3f),
        text = question.question,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 22.sp,
        color = mOffWhite
    )
}