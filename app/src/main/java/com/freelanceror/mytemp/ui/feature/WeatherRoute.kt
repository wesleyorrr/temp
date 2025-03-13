package com.freelanceror.mytemp.ui.feature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.freelanceror.mytemp.data.model.WeatherInfo
import com.freelanceror.mytemp.ui.theme.MyTempTheme

@Composable
fun WeatherRoute(
    viewModel: WeatherViewModel = viewModel() // Obtém o ViewModel automaticamente com Hilt
) {
    // Observa os estados do ViewModel
    val weatherInfoState by viewModel.weatherInfoState.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    // Aplica o tema da aplicação
    MyTempTheme {
        // Exibe a tela de clima com base no estado atual
        WeatherScreen(
            weatherInfo = weatherInfoState.weatherInfo,
            isLoading = isLoading,
            errorMessage = errorMessage
        )
    }
}