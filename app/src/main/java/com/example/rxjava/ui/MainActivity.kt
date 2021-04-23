package com.example.rxjava.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rxjava.App
import com.example.rxjava.R
import com.example.rxjava.databinding.ActivityMainBinding
import com.example.rxjava.util.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind, R.id.container)
    private val viewModel by viewModel { App.component.mainViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}