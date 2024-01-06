package com.example.translatorapp.data.dao.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.translatorapp.data.dao.models.WordEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class WordEntity(

    @ColumnInfo(name = "value")
    val value: String
){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null

    companion object {
        const val TABLE_NAME = "words"
    }

}