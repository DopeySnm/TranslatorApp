package com.example.translatorapp.domain

import androidx.lifecycle.LiveData
import com.example.translatorapp.data.dao.models.WordEntity
import com.example.translatorapp.data.repository.WordsRepository
import javax.inject.Inject

interface GetAllWordUseCase {
    suspend operator fun invoke() : LiveData<List<WordEntity>>
}

class GetAllWordUseCaseImpl @Inject constructor(
    private val repository: WordsRepository
) : GetAllWordUseCase{

    override suspend fun invoke(): LiveData<List<WordEntity>> {
        return repository.getAllWord()
    }

}