package com.ael.diverto.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ael.diverto.ui.theme.*

@Composable
fun EnergyFlowCard(currentPowerWatt: Int) {
    val infiniteTransition = rememberInfiniteTransition(label = "energy_flow")
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 40f,
        animationSpec = infiniteRepeatable(animation = tween(1000, easing = LinearEasing), repeatMode = RepeatMode.Restart), label = "phase"
    )

    GlassCard {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "LIVE ENERGY FLOW",
                color = TextSecondary,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            Box(modifier = Modifier.fillMaxWidth().height(100.dp), contentAlignment = Alignment.Center) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val width = size.width
                    val height = size.height
                    val dashPathEffect = PathEffect.dashPathEffect(floatArrayOf(15f, 15f), -phase)

                    drawLine(
                        color = PrimaryAmber,
                        start = Offset(width * 0.15f, height * 0.5f),
                        end = Offset(width * 0.5f, height * 0.5f),
                        strokeWidth = 6f, pathEffect = dashPathEffect
                    )
                    drawLine(
                        color = AccentPink,
                        start = Offset(width * 0.5f, height * 0.5f),
                        end = Offset(width * 0.85f, height * 0.5f),
                        strokeWidth = 6f, pathEffect = dashPathEffect
                    )
                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    NodeBadge("Panel Surya", "Solar Supply", PrimaryAmber)
                    NodeBadge("Smart Diverter", "$currentPowerWatt W", AccentPink)
                    NodeBadge("Beban Sekunder", "Directing", BatteryGreen)
                }
            }
        }
    }
}

@Composable
fun NodeBadge(label: String, sublabel: String, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(GlassWhite, RoundedCornerShape(14.dp))
            .padding(horizontal = 10.dp, vertical = 8.dp)
    ) {
        Text(text = label, color = TextPrimary, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Text(text = sublabel, color = color, fontSize = 10.sp, fontWeight = FontWeight.Bold)
    }
}