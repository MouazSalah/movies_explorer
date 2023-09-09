package com.areeb.moviesexplorer.ui.main.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.areeb.moviesexplorer.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}