package com.example.translatorapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.translatorapp.di.viewModel.ViewModelFactory
import com.example.translatorapp.di.viewModel.ViewModelKey
import com.example.translatorapp.presenter.translator.TranslatorViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TranslatorViewModel::class)
    abstract fun bindTranslatorViewModel(translatorViewModel: TranslatorViewModel) : ViewModel
}