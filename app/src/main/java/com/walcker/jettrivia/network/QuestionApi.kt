package com.walcker.jettrivia.network

import com.walcker.jettrivia.network.entity.Question
import retrofit2.http.GET
import javax.inject.Singleton

interface QuestionApi {

    @GET("world.json")
    suspend fun getAllQuestions(): Question
}