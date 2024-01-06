package com.example.translatorapp.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.translatorapp.data.db.models.WordEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class WordEntity(

    @ColumnInfo(name = "value")
    val value: String
){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    companion object {
        const val TABLE_NAME = "words"
    }

}