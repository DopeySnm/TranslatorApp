package com.example.translatorapp.presenter.translator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.translatorapp.data.db.models.WordEntity
import com.example.translatorapp.data.models.ResponseData
import com.example.translatorapp.domain.GetAllWordUseCase
import com.example.translatorapp.domain.InsertWordUseCase
import com.example.translatorapp.domain.TranslateUseCase
import com.example.translatorapp.presenter.UiState
import com.example.translatorapp.presenter.toUiState
import kotlinx.coroutines.launch
import javax.inject.Inject

class TranslatorViewModel @Inject constructor(
    private val translateUseCase : TranslateUseCase,
    private val getAllWordUseCase: GetAllWordUseCase,
    private val insertWordUseCase: InsertWordUseCase
) : ViewModel() {

    private var _wordsLiveData = MutableLiveData<List<WordEntity>>()
    val wordsLiveData: LiveData<List<WordEntity>>?
        get() = _wordsLiveData

    private val _translatorLiveData = MutableLiveData<UiState<ResponseData?>>()
    val translatorLiveData: LiveData<UiState<ResponseData?>>
        get() = _translatorLiveData

    init {
        viewModelScope.launch {
            getAllWordUseCase().collect{
                _wordsLiveData.postValue(it)
            }

        }
    }

    fun insertWord(word: String) {
        viewModelScope.launch {
            insertWordUseCase.invoke(WordEntity(word))
        }
    }

//    fun loadWords() {
//        viewModelScope.launch {
//            val result = getAllWordUseCase()
//            _wordsLiveData = result as MutableLiveData<List<WordEntity>>
//        }
//    }


    fun loadTranslator(text: String, langFrom: String, langTo: String) {
        viewModelScope.launch {
            val langPair = "$langFrom|$langTo"
            val result = translateUseCase(text, langPair)
            _translatorLiveData.postValue(result.toUiState())
        }
    }


}