package com.gerali.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gerali.app.ui.GeraliNavHost
import com.gerali.app.ui.theme.GeraliTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GeraliTheme {
                GeraliNavHost()
            }
        }
    }
}
