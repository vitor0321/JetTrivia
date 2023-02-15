package com.walcker.jettrivia.di

import com.walcker.core.usecase.GetAllQuestionsUseCase
import com.walcker.core.usecase.GetAllQuestionsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindUpdateNoteUseCaseUseCase(useCase: GetAllQuestionsUseCaseImpl): GetAllQuestionsUseCase
}