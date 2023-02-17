package com.walcker.jettrivia.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp
import com.walcker.core.model.QuestionItemUI
import com.walcker.jettrivia.presentation.theme.mDarkPurple

@Composable
fun TriviaHomeDisplay(
    questionsFromJson: MutableList<QuestionItemUI>
) {

    val questionIndex = remember { mutableStateOf(1) }
    val question = try {
        questionsFromJson[questionIndex.value -1]
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

            ShowProgressBar(score = questionIndex.value, listQuestionSize = questionsFromJson.size)

            TextTotalAnswer(total = listHitAnswer, text = "Total de acertos: ", color = Color.Green)

            TextTotalAnswer(total = listWrongAnswer, text = "Total de errors: ", color = Color.Red)

            QuestionTracker(counter = questionIndex.value, outOf = questionsFromJson.size)

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
                            listWrongAnswer.value += 1
                        }
                    }
                }

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
                    color = Color.Gray,
                    text = "Next",
                    onNextClicked = {}
                )
            }
        }
    }
}
