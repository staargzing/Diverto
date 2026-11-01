package com.ael.diverto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ael.diverto.ui.DashboardUiState
import com.ael.diverto.ui.components.EnergyFlowCard
import com.ael.diverto.ui.components.GlassCard
import com.ael.diverto.ui.theme.*

@Composable
fun HomeScreen(
    uiState: DashboardUiState,
    onModeToggle: (Boolean) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        // 1. Status Active Card
        GlassCard {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(CircleShape)
                                .padding(end = 4.dp)
                        )
                        Text(
                            text = if (uiState.isConnected) "Smart Diverter Active" else "Disconnected",
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary,
                            fontSize = 15.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (uiState.isAutoMode) "Edge-AI Autonomous Mode" else "Manual Bypass Mode",
                        color = AccentPink,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Switch(
                    checked = uiState.isAutoMode,
                    onCheckedChange = onModeToggle,
                    colors = SwitchDefaults.colors(checkedTrackColor = AccentPink)
                )
            }
        }

        // 2. Estimasi Penghematan Card
        GlassCard {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "ESTIMASI PENGHEMATAN HARI INI",
                    color = TextSecondary,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Rp ${String.format("%,d", uiState.rupiahSavedToday).replace(',', '.')}",
                    color = PrimaryAmber,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Daya Diselamatkan • ${uiState.currentDivertedPowerWatt} W Diverted",
                    color = BatteryGreen,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        // 3. Live Energy Flow Card
        EnergyFlowCard(currentPowerWatt = uiState.currentDivertedPowerWatt)
    }
}