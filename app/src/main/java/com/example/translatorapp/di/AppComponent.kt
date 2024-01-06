package com.example.translatorapp.di

import com.example.translatorapp.presenter.translator.TranslatorFragment
import dagger.Component

@Component(
    modules = [ AppModule::class ]
)
interface AppComponent {
    fun inject(fragment: TranslatorFragment)
}
