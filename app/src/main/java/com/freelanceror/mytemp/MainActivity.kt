package com.freelanceror.mytemp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.freelanceror.mytemp.ui.feature.WeatherRoute
import com.freelanceror.mytemp.ui.theme.MyTempTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTempTheme {
                WeatherRoute()
            }
        }
    }
}