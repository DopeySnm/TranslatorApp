package com.example.translatorapp.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.translatorapp.data.dao.WordsDao
import com.example.translatorapp.data.dao.models.WordEntity

@Database(
    entities = [
        WordEntity::class
    ],
    version = 1,
    exportSchema = true
)
abstract class WordsDatabase : RoomDatabase() {
    abstract fun wordDao(): WordsDao

}