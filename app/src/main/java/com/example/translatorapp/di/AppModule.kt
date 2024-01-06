package com.example.translatorapp.di

import com.example.translatorapp.di.modules.*
import dagger.Module


@Module(
    includes = [
        NetworkModule::class,
        AppBindsModule::class,
        ViewModelModule::class,
        RoomModule::class
    ]
)
class AppModule