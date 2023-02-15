package com.walcker.jettrivia.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.walcker.jettrivia.presentation.theme.mOffDarkPurple
import com.walcker.jettrivia.presentation.theme.mOffWhite

@Composable
fun AnswerChoice(
    choiceState: MutableList<String>,
    answerState: MutableState<Int?>,
    correctAnswerState: MutableState<Boolean?>,
    updateAnswer: (Int) -> Unit
) {
    choiceState.forEachIndexed { index, answerText ->
        Row(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .height(45.dp)
                .border(
                    width = 4.dp, brush = Brush.linearGradient(
                        colors = listOf(mOffDarkPurple, mOffDarkPurple)
                    ),
                    shape = RoundedCornerShape(15.dp)
                )
                .clip(
                    RoundedCornerShape(
                        topStartPercent = 50,
                        topEndPercent = 50,
                        bottomEndPercent = 50,
                        bottomStartPercent = 50
                    )
                )
                .background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(modifier = Modifier.padding(start = 16.dp),
                selected = (answerState.value == index),
                colors = RadioButtonDefaults.colors(
                    selectedColor =
                    if (correctAnswerState.value == true && index == answerState.value) {
                        Color.Green.copy(alpha = 0.2f)
                    } else {
                        Color.Red.copy(alpha = 0.2f)
                    },
                    unselectedColor = mOffWhite,
                ),
                onClick = { updateAnswer(index) }
            )
            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Light,
                        color = if (correctAnswerState.value == true && index == answerState.value) {
                            Color.Green
                        } else if (correctAnswerState.value == false && index == answerState.value) {
                            Color.Red
                        } else mOffWhite,
                        fontSize = 17.sp
                    )
                ) {
                    append(answerText)
                }
            }

            Text(text = annotatedString, modifier = Modifier.padding(6.dp))
        }
    }
}