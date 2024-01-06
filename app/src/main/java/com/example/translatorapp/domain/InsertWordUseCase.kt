package com.example.translatorapp.domain

import com.example.translatorapp.data.db.models.WordEntity
import com.example.translatorapp.data.repository.WordsRepository
import javax.inject.Inject

interface InsertWordUseCase {
    suspend operator fun invoke(word: WordEntity)
}

class InsertWordUseCaseImpl @Inject constructor(
    private val repository: WordsRepository
) : InsertWordUseCase{
    override suspend fun invoke(word: WordEntity) {
        repository.insertWord(word)
    }
}