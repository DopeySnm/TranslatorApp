package com.example.translatorapp.data.models

data class TranslateResp(
    val responseData: ResponseData,
)

data class ResponseData(
    val translatedText: String,
)