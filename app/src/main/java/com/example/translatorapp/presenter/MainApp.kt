package com.example.translatorapp.presenter

import android.app.Application
import com.example.translatorapp.di.AppComponent
import com.example.translatorapp.di.DaggerAppComponent
import com.example.translatorapp.di.modules.RoomModule

class MainApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .roomModule(RoomModule(applicationContext))
            .build()
    }

}