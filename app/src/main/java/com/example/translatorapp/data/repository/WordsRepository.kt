package com.example.translatorapp.data.repository

import androidx.lifecycle.LiveData
import com.example.translatorapp.data.dao.WordsDao
import com.example.translatorapp.data.dao.models.WordEntity
import javax.inject.Inject

interface WordsRepository {
    suspend fun insertWord(word: WordEntity)

    suspend fun getAllWord() : LiveData<List<WordEntity>>
}

class WordsRepositoryImpl @Inject constructor(
    private val wordDao: WordsDao
) : WordsRepository{

    override suspend fun insertWord(word: WordEntity) {
        wordDao.insert(word)
    }

    override suspend fun getAllWord(): LiveData<List<WordEntity>> {
        return wordDao.getAllWord()
    }
}