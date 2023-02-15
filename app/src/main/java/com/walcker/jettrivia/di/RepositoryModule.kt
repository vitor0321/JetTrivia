package com.walcker.jettrivia.di

import com.walcker.core.data.repository.QuestionRepository
import com.walcker.jettrivia.network.repository.QuestionRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindQuestionRepository(repository: QuestionRepositoryImpl): QuestionRepository
}