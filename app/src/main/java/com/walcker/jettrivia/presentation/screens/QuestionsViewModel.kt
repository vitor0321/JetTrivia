package com.walcker.jettrivia.presentation.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walcker.core.data.DataOrException
import com.walcker.core.data.repository.QuestionRepository
import com.walcker.core.model.QuestionItemUI
import com.walcker.core.usecase.GetAllQuestionsUseCase
import com.walcker.core.usecase.base.CoroutinesDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val getAllQuestionsUseCase: GetAllQuestionsUseCase
) : ViewModel() {

    val data: MutableState<DataOrException<List<QuestionItemUI>, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))

    init {
        getAllQuestions()
    }

    private fun getAllQuestions() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = getAllQuestionsUseCase()
            if (data.value.data.toString().isNotEmpty()){
                data.value.loading = false
            }
        }
    }
}