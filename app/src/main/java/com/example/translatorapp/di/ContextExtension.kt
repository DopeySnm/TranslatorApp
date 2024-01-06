package com.example.translatorapp.di

import android.content.Context
import com.example.translatorapp.presenter.MainApp

val Context.appComponent: AppComponent
    get() = when(this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }