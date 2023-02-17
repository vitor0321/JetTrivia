package com.walcker.jettrivia.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.walcker.core.model.QuestionItemUI
import com.walcker.jettrivia.presentation.theme.mDarkPurple
import com.walcker.jettrivia.presentation.theme.mLightGray
import com.walcker.jettrivia.presentation.theme.mOffWhite

@Composable
fun TriviaHomeDisplay(
    questionsFromJson: MutableList<QuestionItemUI>
) {

    val questionIndex = remember { mutableStateOf(0) }
    val question = try {
        questionsFromJson[questionIndex.value]
    } catch (ex: Exception) {
        null
    }
    val answerCheckState = remember(question) { mutableStateOf<Boolean?>(null) }
    val answerIndexState = remember(question) { mutableStateOf<Int?>(null) }
    val listHitAnswer = remember { mutableStateOf<Int>(0) }
    val listWrongAnswer = remember { mutableStateOf<Int>(0) }

    val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = mDarkPurple
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {

            if (questionIndex.value >= 3) ShowProgressBar(score = questionIndex.value, listQuestionSize = questionsFromJson.size)

            Text(
                text = (questionIndex.value).toString(),
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(23.dp))
                    .padding(start = 12.dp, top = 6.dp),
                color = mOffWhite,
                textAlign = TextAlign.Start
            )

            QuestionTracker(
                counter = questionIndex.value,
                outOf = questionsFromJson.size
            )

            DrawDottedLine(pathEffect = pathEffect)


            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                question?.let { questionItemUI ->
                    QuestionText(questionItemUI)

                    AnswerChoice(questionItemUI.choices, answerCheckState, answerIndexState) { answer, index ->
                        answerCheckState.value = questionItemUI.answer == answer
                        answerIndexState.value = index
                        if (questionItemUI.answer == answer) {
                            listHitAnswer.value += 1
                        } else {
                            listWrongAnswer.value + 1
                        }
                    }
                }
                Text(text = listHitAnswer.value.toString())

                Text(text = listWrongAnswer.value.toString())

                when (answerCheckState.value) {
                    true -> Icon(
                        modifier = Modifier
                            .size(150.dp)
                            .padding(end = 12.dp),
                        imageVector = Icons.Default.Check,
                        tint = Color.Green,
                        contentDescription = " Hit Icon"
                    )
                    false -> Icon(
                        modifier = Modifier
                            .size(150.dp)
                            .padding(end = 12.dp),
                        imageVector = Icons.Default.Close,
                        tint = Color.Red,
                        contentDescription = "Wrong Icon"
                    )
                    else -> Text(text = "")
                }
            }
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (answerCheckState.value != null) {
                ButtonTrivia(
                    text = "Next",
                    onNextClicked = {
                        questionIndex.value = questionIndex.value + 1
                    })
            } else {
                ButtonTrivia(
                    enabled = false,
                    color = Color.Gray.copy(alpha = 0.1f),
                    text = "Next",
                    onNextClicked = {}
                )
            }
        }
    }
}



