package com.example.translatorapp.data.repository

import com.example.translatorapp.data.api.MyMemoryService
import com.example.translatorapp.data.dao.WordsDao
import com.example.translatorapp.data.dao.models.WordEntity
import com.example.translatorapp.data.models.ResponseData
import javax.inject.Inject


interface MyMemoryRepository {
    suspend fun translate(text: String, langPair: String): Result<ResponseData?>

}

class MyMemoryRepositoryImpl @Inject constructor(
    private val service: MyMemoryService
) : MyMemoryRepository {

    override suspend fun translate(text: String, langPair: String): Result<ResponseData?> {
        kotlin.runCatching {
            service.translate(text, langPair)
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body()?.responseData)
                else Result.failure(retrofit2.HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }

        )
    }

}