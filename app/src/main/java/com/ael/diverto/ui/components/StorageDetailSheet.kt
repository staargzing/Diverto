package com.ael.diverto.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ael.diverto.ui.theme.*
import kotlin.math.sin

enum class StorageType { TOREN_AIR, WATER_HEATER, BATERAI }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StorageDetailSheet(
    type: StorageType,
    value: Int,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        containerColor = LightSurface,
        shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (type) {
                StorageType.TOREN_AIR -> {
                    Text("Detail Kapasitas Toren Air", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                    Spacer(modifier = Modifier.height(16.dp))
                    AnimatedTorenCanvas(percent = value)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Toren terisi $value%. Pengalihan energi aktif mengisi pompa air.", fontSize = 13.sp, color = TextSecondary)
                }
                StorageType.WATER_HEATER -> {
                    Text("Detail Suhu Water Heater", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                    Spacer(modifier = Modifier.height(16.dp))
                    AnimatedHeaterCanvas(tempC = value)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Suhu saat ini $value°C (Optimal). Energi surya dialihkan ke pemanas termal.", fontSize = 13.sp, color = TextSecondary)
                }
                StorageType.BATERAI -> {
                    Text("Detail Baterai Portabel", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
                    Spacer(modifier = Modifier.height(16.dp))
                    AnimatedBatteryCanvas(percent = value)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Kapasitas pengisian $value%. Siap digunakan sebagai daya cadangan malam hari.", fontSize = 13.sp, color = TextSecondary)
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(containerColor = TextPrimary),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Tutup", color = Color.White)
            }
        }
    }
}

// Animasi Air Bergelombang dalam Toren
@Composable
fun AnimatedTorenCanvas(percent: Int) {
    val transition = rememberInfiniteTransition(label = "wave")
    val wavePhase by transition.animateFloat(
        initialValue = 0f, targetValue = 2f * Math.PI.toFloat(),
        animationSpec = infiniteRepeatable(tween(1500, easing = LinearEasing)), label = "wavePhase"
    )

    Box(contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(160.dp, 200.dp)) {
            val w = size.width
            val h = size.height

            // Tabung Toren
            drawRoundRect(color = TextSecondary.copy(alpha = 0.2f), size = size, cornerRadius = androidx.compose.ui.geometry.CornerRadius(20f), style = Stroke(6f))

            // Gelombang Air
            val waterHeight = h * (percent / 100f)
            val wavePath = Path().apply {
                moveTo(0f, h - waterHeight)
                var x = 0f
                while (x <= w) {
                    val y = (h - waterHeight) + sin(x * 0.05f + wavePhase) * 10f
                    lineTo(x, y)
                    x += 5f
                }
                lineTo(w, h)
                lineTo(0f, h)
                close()
            }
            drawPath(path = wavePath, color = EnergyCyan)
        }
        Text("$percent%", fontSize = 32.sp, fontWeight = FontWeight.ExtraBold, color = TextPrimary)
    }
}

// Animasi Indikator Pemanas Water Heater
@Composable
fun AnimatedHeaterCanvas(tempC: Int) {
    val transition = rememberInfiniteTransition(label = "heat")
    val pulseAlpha by transition.animateFloat(
        initialValue = 0.4f, targetValue = 1f,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing), repeatMode = RepeatMode.Reverse), label = "pulse"
    )

    Box(contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(180.dp)) {
            val center = Offset(size.width / 2, size.height / 2)
            drawCircle(color = HeaterRed.copy(alpha = 0.15f), radius = 80.dp.toPx())
            drawCircle(color = HeaterRed.copy(alpha = pulseAlpha * 0.4f), radius = (tempC * 0.9).dp.toPx())
            drawCircle(color = HeaterRed, radius = 70.dp.toPx(), style = Stroke(10f))
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("$tempC°C", fontSize = 36.sp, fontWeight = FontWeight.ExtraBold, color = HeaterRed)
            Text("OPTIMAL", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = TextSecondary)
        }
    }
}

// Animasi Pengisian Baterai
@Composable
fun AnimatedBatteryCanvas(percent: Int) {
    val transition = rememberInfiniteTransition(label = "charge")
    val chargeWidth by transition.animateFloat(
        initialValue = 0f, targetValue = percent / 100f,
        animationSpec = infiniteRepeatable(tween(2000, easing = FastOutSlowInEasing), repeatMode = RepeatMode.Restart), label = "charge"
    )

    Box(contentAlignment = Alignment.Center) {
        Canvas(modifier = Modifier.size(200.dp, 100.dp)) {
            val w = size.width
            val h = size.height

            // Body Baterai
            drawRoundRect(color = TextSecondary.copy(alpha = 0.3f), size = Size(w * 0.85f, h), cornerRadius = androidx.compose.ui.geometry.CornerRadius(16f), style = Stroke(6f))
            drawRoundRect(color = TextSecondary.copy(alpha = 0.3f), topLeft = Offset(w * 0.86f, h * 0.3f), size = Size(w * 0.1f, h * 0.4f), cornerRadius = androidx.compose.ui.geometry.CornerRadius(6f))

            // Isi Daya Animasi
            drawRoundRect(color = BatteryGreen, topLeft = Offset(8f, 8f), size = Size((w * 0.85f - 16f) * chargeWidth, h - 16f), cornerRadius = androidx.compose.ui.geometry.CornerRadius(12f))
        }
        Text("⚡ $percent%", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = TextPrimary)
    }
}