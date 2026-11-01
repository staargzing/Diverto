package com.ael.diverto.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class DashboardUiState(
    val isConnected: Boolean = true,
    val isAutoMode: Boolean = true,
    val rupiahSavedToday: Int = 25000,
    val currentDivertedPowerWatt: Int = 420,
    val torenCapacityPercent: Int = 85,
    val waterHeaterTempC: Int = 60,
    val portableBatteryPercent: Int = 74
)

class SmartDiverterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    init {
        startRealtimeSimulation()
    }

    fun toggleMode(isAuto: Boolean) {
        _uiState.update { it.copy(isAutoMode = isAuto) }
    }

    private fun startRealtimeSimulation() {
        viewModelScope.launch {
            while (true) {
                delay(2000)
                _uiState.update { state ->
                    val powerDelta = (-15..15).random()
                    val newPower = (state.currentDivertedPowerWatt + powerDelta).coerceIn(380, 500)
                    val newRupiah = state.rupiahSavedToday + (newPower / 100)

                    state.copy(
                        currentDivertedPowerWatt = newPower,
                        rupiahSavedToday = newRupiah
                    )
                }
            }
        }
    }
}