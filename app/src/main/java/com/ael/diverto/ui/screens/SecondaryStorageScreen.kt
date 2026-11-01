package com.ael.diverto.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ael.diverto.ui.DashboardUiState
import com.ael.diverto.ui.components.GlassCard
import com.ael.diverto.ui.components.StorageType
import com.ael.diverto.ui.theme.*

@Composable
fun SecondaryStorageScreen(
    uiState: DashboardUiState,
    onItemClick: (StorageType) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text(
            text = "PENYIMPANAN SEKUNDER",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = TextSecondary,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(start = 4.dp, top = 4.dp)
        )

        // 1. Kapasitas Toren Air
        GlassCard(onClick = { onItemClick(StorageType.TOREN_AIR) }) {
            StorageRowItem(
                title = "💧 Kapasitas Toren Air",
                statusText = "${uiState.torenCapacityPercent}% Full",
                progress = uiState.torenCapacityPercent / 100f,
                progressColor = EnergyCyan
            )
        }

        // 2. Suhu Water Heater
        GlassCard(onClick = { onItemClick(StorageType.WATER_HEATER) }) {
            StorageRowItem(
                title = "🔥 Suhu Water Heater",
                statusText = "${uiState.waterHeaterTempC}°C Optimal",
                progress = uiState.waterHeaterTempC / 100f,
                progressColor = HeaterRed
            )
        }

        // 3. Baterai Portabel
        GlassCard(onClick = { onItemClick(StorageType.BATERAI) }) {
            StorageRowItem(
                title = "⚡ Estimasi Baterai Portabel",
                statusText = "${uiState.portableBatteryPercent}% Charging",
                progress = uiState.portableBatteryPercent / 100f,
                progressColor = BatteryGreen
            )
        }
    }
}

@Composable
fun StorageRowItem(
    title: String,
    statusText: String,
    progress: Float,
    progressColor: Color
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = TextPrimary
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Klik untuk detail animasi",
                    fontSize = 10.sp,
                    color = TextSecondary
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = statusText,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 13.sp,
                color = progressColor
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = progressColor,
            trackColor = TextSecondary.copy(alpha = 0.12f)
        )
    }
}