package com.ael.diverto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ael.diverto.ui.SmartDiverterViewModel
import com.ael.diverto.ui.components.AppHeader
import com.ael.diverto.ui.components.StorageDetailSheet
import com.ael.diverto.ui.components.StorageType
import com.ael.diverto.ui.screens.HomeScreen
import com.ael.diverto.ui.screens.SecondaryStorageScreen
import com.ael.diverto.ui.screens.SplashScreen
import com.ael.diverto.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DivertoTheme {
                var showSplash by remember { mutableStateOf(true) }

                if (showSplash) {
                    SplashScreen(onSplashFinished = { showSplash = false })
                } else {
                    MainAppLayout()
                }
            }
        }
    }
}

@Composable
fun MainAppLayout(viewModel: SmartDiverterViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var selectedTab by remember { mutableIntStateOf(0) } // 0: Home, 1: Secondary Storage
    var selectedDetailType by remember { mutableStateOf<StorageType?>(null) }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = LightSurface) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    label = { Text("Home", fontWeight = FontWeight.Bold) },
                    icon = { Text("🏠") },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = PrimaryAmber.copy(alpha = 0.2f))
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    label = { Text("Secondary Storage", fontWeight = FontWeight.Bold) },
                    icon = { Text("🔋") },
                    colors = NavigationBarItemDefaults.colors(indicatorColor = PrimaryAmber.copy(alpha = 0.2f))
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LightBackground)
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            AppHeader()
            Spacer(modifier = Modifier.height(12.dp))

            when (selectedTab) {
                0 -> HomeScreen(uiState = uiState, onModeToggle = { viewModel.toggleMode(it) })
                1 -> SecondaryStorageScreen(uiState = uiState, onItemClick = { selectedDetailType = it })
            }
        }
    }

    // Modal Detail Sheet saat Card Secondary Storage dipencet
    selectedDetailType?.let { type ->
        val value = when (type) {
            StorageType.TOREN_AIR -> uiState.torenCapacityPercent
            StorageType.WATER_HEATER -> uiState.waterHeaterTempC
            StorageType.BATERAI -> uiState.portableBatteryPercent
        }
        StorageDetailSheet(type = type, value = value, onDismiss = { selectedDetailType = null })
    }
}