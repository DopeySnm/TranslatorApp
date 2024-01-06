package com.example.translatorapp.domain

import androidx.lifecycle.LiveData
import com.example.translatorapp.data.db.models.WordEntity
import com.example.translatorapp.data.repository.WordsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetAllWordUseCase {
    suspend operator fun invoke() : Flow<List<WordEntity>>
}

class GetAllWordUseCaseImpl @Inject constructor(
    private val repository: WordsRepository
) : GetAllWordUseCase{

    override suspend fun invoke(): Flow<List<WordEntity>> {
        return repository.getAllWord()
    }

}