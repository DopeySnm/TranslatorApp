package com.example.translatorapp.di.modules

import com.example.translatorapp.data.api.MyMemoryService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    @Provides
    fun provideMyMemoryService(): MyMemoryService =
        Retrofit.Builder()
            .baseUrl("https://api.mymemory.translated.net")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyMemoryService::class.java)
}