package com.example.translatorapp.di.modules

import com.example.translatorapp.data.repository.MyMemoryRepository
import com.example.translatorapp.data.repository.MyMemoryRepositoryImpl
import com.example.translatorapp.data.repository.WordsRepository
import com.example.translatorapp.data.repository.WordsRepositoryImpl
import com.example.translatorapp.domain.*
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {

    @Binds
    fun bindGetAllWordUseCase(useCase: GetAllWordUseCaseImpl): GetAllWordUseCase

    @Binds
    fun bindInsertWordUseCase(useCase: InsertWordUseCaseImpl): InsertWordUseCase

    @Binds
    fun bindTranslatorUseCase(useCase: TranslateUseCaseImpl) : TranslateUseCase

    @Binds
    fun bindMyMemoryRepository(repository: MyMemoryRepositoryImpl) : MyMemoryRepository

    @Binds
    fun bindWordsRepository(repositoryImpl: WordsRepositoryImpl) : WordsRepository
}