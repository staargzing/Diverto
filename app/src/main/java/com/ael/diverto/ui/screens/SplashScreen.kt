package com.ael.diverto.ui.screens

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ael.diverto.R
import com.ael.diverto.ui.theme.LightBackground
import com.ael.diverto.ui.theme.PrimaryAmber
import com.ael.diverto.ui.theme.TextPrimary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    var startAnimation by remember { mutableStateOf(false) }

    // Easing kustom versi Compose (Overshoot effect tanpa error reflection)
    val overshootEasing = Easing { fraction ->
        val tension = 2.0f
        val t = fraction - 1.0f
        t * t * ((tension + 1) * t + tension) + 1.0f
    }

    val scaleAnim by animateFloatAsState(
        targetValue = if (startAnimation) 1.1f else 0.6f,
        animationSpec = tween(durationMillis = 1000, easing = overshootEasing),
        label = "logo_scale"
    )

    LaunchedEffect(Unit) {
        startAnimation = true
        delay(2200)
        onSplashFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBackground),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.divertologo),
                contentDescription = "Logo Diverto",
                modifier = Modifier
                    .size(140.dp)
                    .scale(scaleAnim)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Diverto",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Zero-Waste Edge-AI Solar Monitoring",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = PrimaryAmber
            )
        }
    }
}