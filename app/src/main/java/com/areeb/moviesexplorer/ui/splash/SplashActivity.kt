package com.areeb.moviesexplorer.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.areeb.moviesexplorer.R
import com.areeb.moviesexplorer.ui.main.base.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {

    private val SPLASH_DURATION_MS : Long = 3000
    private var delayJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        delayJob = lifecycleScope.launch {
            delay(SPLASH_DURATION_MS)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }


    override fun onDestroy() {
        delayJob?.cancel()
        super.onDestroy()
    }
}