package com.walcker.core.usecase

import com.walcker.core.data.DataOrException
import com.walcker.core.data.repository.QuestionRepository
import com.walcker.core.model.QuestionItemUI
import com.walcker.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetAllQuestionsUseCase {
    suspend operator fun invoke(params: Unit = Unit): DataOrException<List<QuestionItemUI>, Boolean, Exception>
}

class GetAllQuestionsUseCaseImpl @Inject constructor(
    private val questionRepository: QuestionRepository,
    private val coroutinesDispatchers: CoroutinesDispatchers
) : GetAllQuestionsUseCase {
    override suspend fun invoke(params: Unit): DataOrException<List<QuestionItemUI>, Boolean, Exception> {
        return withContext(coroutinesDispatchers.io()){
            questionRepository.getAllQuestions()
        }
    }
}