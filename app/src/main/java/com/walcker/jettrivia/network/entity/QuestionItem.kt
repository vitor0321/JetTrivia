package com.walcker.jettrivia.network.entity

import com.google.gson.annotations.SerializedName
import com.walcker.core.model.QuestionItemUI

data class QuestionItem(
    @SerializedName("answer")
    val answer: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("choices")
    val choices: List<String>,
    @SerializedName("question")
    val question: String
)

fun List<QuestionItem>.toQuestionItemUIModel() = map {
    QuestionItemUI(
        answer = it.answer,
        category = it.category,
        choices = it.choices,
        question = it.question
    )
}