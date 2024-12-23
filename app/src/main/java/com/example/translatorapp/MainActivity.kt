package com.example.translatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.translatorapp.databinding.ActivityMainBinding
import com.example.translatorapp.presenter.RootFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(binding.rootFragmentHost.id, RootFragment())
            .commit()
    }
}