package com.example.translatorapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.translatorapp.data.db.models.WordEntity

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