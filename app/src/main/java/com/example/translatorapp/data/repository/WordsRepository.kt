package com.example.translatorapp.data.repository

import androidx.lifecycle.LiveData
import com.example.translatorapp.data.db.WordsDao
import com.example.translatorapp.data.db.models.WordEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface WordsRepository {
    suspend fun insertWord(word: WordEntity)

    suspend fun getAllWord() : Flow<List<WordEntity>>
}

class WordsRepositoryImpl @Inject constructor(
    private val wordDao: WordsDao
) : WordsRepository{

    override suspend fun insertWord(word: WordEntity) {
        wordDao.insert(word)
    }

    override suspend fun getAllWord(): Flow<List<WordEntity>> {
        return wordDao.getAllWord()
    }
}