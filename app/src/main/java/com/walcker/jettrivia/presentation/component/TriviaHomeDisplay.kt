package com.walcker.jettrivia.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.walcker.core.model.QuestionItemUI
import com.walcker.jettrivia.presentation.theme.mDarkPurple
import com.walcker.jettrivia.presentation.theme.mOffWhite

@Composable
fun TriviaHomeDisplay(
    questions: MutableList<QuestionItemUI>
) {

    val questionIndex = remember { mutableStateOf(0) }

    val question = try {
        questions[questionIndex.value]
    } catch (ex: Exception) {
        null
    }

    val questionState = remember(question) { question?.choices?.toMutableList() }
    val answerState = remember(question) { mutableStateOf<Int?>(null) }
    val correctAnswerState = remember(question) { mutableStateOf<Boolean?>(null) }
    val updateAnswer: (Int) -> Unit = remember(question) {
        {
            answerState.value = it
            correctAnswerState.value = (questionState?.get(it) ?: 0) == question?.answer
        }
    }


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

            if (questionIndex.value >= 3) ShowProgress(score = questionIndex.value, listQuestionSize = questions.size)

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
                outOf = questions.size
            )

            DrawDottedLine(pathEffect = pathEffect)

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                question?.let {
                    QuestionText(question)

                    questionState?.let { questions ->
                        AnswerChoice(questions, answerState, correctAnswerState, updateAnswer)
                    }
                }
            }
        }
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ButtonNext(onNextClicked = {
                questionIndex.value = questionIndex.value + 1
            })
        }
    }
}



