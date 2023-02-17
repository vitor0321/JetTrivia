package com.walcker.core.data.repository

import com.walcker.core.data.DataOrException
import com.walcker.core.model.QuestionItemUI

interface QuestionRepository {

    suspend fun getAllQuestions(): DataOrException<List<QuestionItemUI>, Boolean, Exception>
}