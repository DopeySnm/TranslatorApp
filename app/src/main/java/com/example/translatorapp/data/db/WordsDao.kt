package com.example.translatorapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.translatorapp.data.db.models.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WordsDao {

    @Insert
    fun insert(word: WordEntity)

    @Query("SELECT * FROM ${WordEntity.TABLE_NAME}")
    fun getAllWord() : Flow<List<WordEntity>>
}