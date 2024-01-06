package com.example.translatorapp.domain

import com.example.translatorapp.data.models.ResponseData
import com.example.translatorapp.data.repository.MyMemoryRepository
import javax.inject.Inject

interface TranslateUseCase {
    suspend operator fun invoke(text: String, langPair: String): Result<ResponseData?>
}

class TranslateUseCaseImpl @Inject constructor(
    private val repository: MyMemoryRepository
) : TranslateUseCase {
    override suspend fun invoke(text: String, langPair: String): Result<ResponseData?>{
        return repository.translate(text, langPair)
    }
}