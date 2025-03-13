package com.freelanceror.mytemp.ui.feature

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.freelanceror.mytemp.data.model.WeatherInfo
import com.freelanceror.mytemp.ui.theme.MyTempTheme
import com.freelanceror.mytemp.ui.theme.BlueSky

@Composable
fun WeatherScreen(
    context: Context = LocalContext.current,
    weatherInfo: WeatherInfo?,
    isLoading: Boolean,
    errorMessage: String?
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = if (weatherInfo?.isDay == true) BlueSky else Color.DarkGray
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center // Centraliza o conteúdo dentro do Box
        ) {
            when {
                isLoading -> {
                    // Mostra o indicador de carregamento
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center) // Centraliza o indicador
                    )
                }
                errorMessage != null -> {
                    // Mostra a mensagem de erro
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Center) // Centraliza o texto
                    )
                }
                weatherInfo != null -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = weatherInfo.locationName,
                            color = Color.White,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = weatherInfo.dayOfWeek,
                            color = Color.White,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        val iconDrawableResId: Int = context.resources.getIdentifier(
                            "weather_${weatherInfo.conditionIcon}",
                            "drawable",
                            context.packageName
                        )

                        Image(
                            painter = painterResource(id = iconDrawableResId),
                            contentDescription = null,
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = weatherInfo.condition,
                            color = Color.White,
                            style = MaterialTheme.typography.bodySmall
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        Text(
                            text = "${weatherInfo.temperature}°",
                            color = Color.White,
                            style = MaterialTheme.typography.displayLarge
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun WeatherScreenPreview() {
    MyTempTheme {
        WeatherScreen(
            weatherInfo = WeatherInfo(
                locationName = "Belo Horizonte",
                conditionIcon = "01d",
                condition = "Cloudy",
                temperature = 32,
                dayOfWeek = "Saturday",
                isDay = true,
            ),
            isLoading = false,
            errorMessage = null
        )
    }
}