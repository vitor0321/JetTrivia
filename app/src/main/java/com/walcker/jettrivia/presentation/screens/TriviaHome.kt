package com.walcker.jettrivia.presentation.screens

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.walcker.jettrivia.presentation.component.TriviaHomeDisplay

@Composable
fun TriviaHome(viewModel: QuestionsViewModel = hiltViewModel()) {

    val questions = viewModel.data.value.data?.toMutableList()


    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
    } else {
        if (questions != null) {
            TriviaHomeDisplay(questions = questions)
        }
    }
}