package com.example.translatorapp.presenter.translator

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.translatorapp.R
import com.example.translatorapp.data.models.ResponseData
import com.example.translatorapp.databinding.FragmentTranslatorBinding
import com.example.translatorapp.di.appComponent
import com.example.translatorapp.di.viewModel.ViewModelFactory
import com.example.translatorapp.presenter.UiState
import javax.inject.Inject

class TranslatorFragment : Fragment(R.layout.fragment_translator) {

    private val binding: FragmentTranslatorBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: TranslatorViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.translatorLiveData.observe(viewLifecycleOwner) {
            onTranslateDataReceived(it)
        }

        binding.translateButton.setOnClickListener {
            viewModel.loadTranslator(binding.editText.toString(), "en", "ru")
        }

        binding.addWordButton.setOnClickListener {
            viewModel.insertWord(binding.editText.toString())
        }

        viewModel.wordsLiveData.observe(viewLifecycleOwner) {
            binding.getWordsButton.text = it.first().value
        }
    }

    private fun onTranslateDataReceived(translate: UiState<ResponseData?>?) {
        when(translate) {
            is UiState.Success -> {
                binding.textView.isEnabled = true
                translate.value?.let {
                    binding.textView.text = it.translatedText
                }
            }
            is UiState.Loading -> {
                binding.textView.isEnabled = false
            }
            is UiState.Failure -> {
            binding.textView.isEnabled = false
            }
            else -> {}
        }
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

}