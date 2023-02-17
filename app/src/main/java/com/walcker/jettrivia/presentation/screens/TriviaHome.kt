package com.walcker.jettrivia.presentation.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.walcker.jettrivia.presentation.component.InitialLoading
import com.walcker.jettrivia.presentation.component.TriviaHomeDisplay

@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()) {

    val questions = viewModel.data.value.data?.toMutableList()

    if (viewModel.data.value.loading == true) {
        InitialLoading()
    } else {
        if (questions != null) {
            TriviaHomeDisplay(questionsFromJson = questions)
        }
    }
}