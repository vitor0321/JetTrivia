package com.walcker.core.model

data class QuestionItemUI(
    val answer: String,
    val category: String,
    val choices: List<String>,
    val question: String
)
