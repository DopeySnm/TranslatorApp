package com.example.translatorapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.translatorapp.data.dao.models.WordEntity

@Dao
interface WordsDao {

    @Insert
    fun insert(word: WordEntity)

    @Query("SELECT * FROM ${WordEntity.TABLE_NAME}")
    fun getAllWord() : LiveData<List<WordEntity>>
}