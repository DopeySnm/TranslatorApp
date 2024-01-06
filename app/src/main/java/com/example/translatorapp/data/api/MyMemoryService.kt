package com.example.translatorapp.data.api

import com.example.translatorapp.data.models.TranslateResp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MyMemoryService {

    @GET("get")
    suspend fun translate(
        @Query("q") text: String,
        @Query("langpair") langPair: String // Format "lang from"|"lang to"
        ): Response<TranslateResp>

}