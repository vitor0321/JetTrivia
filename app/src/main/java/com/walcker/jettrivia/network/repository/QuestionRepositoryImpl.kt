package com.walcker.jettrivia.network.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.walcker.core.data.DataOrException
import com.walcker.core.data.repository.QuestionRepository
import com.walcker.core.model.QuestionItemUI
import com.walcker.jettrivia.network.QuestionApi
import com.walcker.jettrivia.network.entity.toQuestionItemUIModel
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val api: QuestionApi
) : QuestionRepository {
    private val dataOrException = DataOrException<List<QuestionItemUI>, Boolean, Exception>()

    override suspend fun getAllQuestions(): DataOrException<List<QuestionItemUI>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions().toQuestionItemUIModel()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d(TAG, "getAllQuestions: ${dataOrException.e?.localizedMessage}")
        }
        return dataOrException
    }
}