package com.example.translatorapp.di.modules

import android.content.Context
import androidx.room.Room
import com.example.translatorapp.data.db.WordsDatabase
import com.example.translatorapp.data.db.WordsDao
import dagger.Module
import dagger.Provides

@Module
class RoomModule(private val applicationContext: Context) {

    @Provides
    fun provideDatabase() =
        Room.databaseBuilder(
            applicationContext,
            WordsDatabase::class.java,
            "Words"
        ).build()

    @Provides
    fun provideWordDao(wordDB: WordsDatabase) : WordsDao {
        return wordDB.wordDao()
    }
}