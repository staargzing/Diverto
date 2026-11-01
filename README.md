<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/f814756e-2df0-400f-9c5d-5a656d5c97a2" /><img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/0138a3cd-d48f-4607-b8ea-fd46fb5fe058" /><img width="1080" height="2400" alt="image" src="https://github.com/user-attachments/assets/bd00f8e1-f557-48a6-a83f-7dacc5895eda" /># ☀️ Diverto — Zero-Waste Edge-AI Solar Energy Monitoring

> **"Empowering Sustainable Energy Efficiency with Real-Time Edge-AI Diversion & Minimalist Glassmorphism UI."**

**Diverto** is a modern Android mobile application built for smart solar energy ecosystems. Designed specifically to eliminate renewable energy waste, Diverto dynamically monitors and redirects excess solar power generation (*overproduction*) into secondary storage assets—such as water storage tanks, thermal water heaters, and portable batteries—maximizing operational efficiency and daily financial savings.

---

## ✨ Key Features

- **⚡ Live Energy Flow & Financial Counter**: Real-time simulation and tracking of diverted solar wattage (W) and daily accumulated cost savings (Rp) with active canvas line animations.
- **🤖 Edge-AI Autonomous Control**: Seamlessly toggle between **AUTO** (*Edge-AI Autonomous Diversion Mode*) and **MANUAL** (*Bypass Mode*).
- **💧 Secondary Storage Monitoring & Interactive Modal Sheets**:
  - **Water Tank (Toren Air)**: Custom wave canvas animation displaying real-time liquid percentage.
  - **Thermal Water Heater**: Pulsing temperature canvas indicator (°C).
  - **Portable Battery Storage**: Charging progress animation showing reserve power capacity (%).
- **🎨 Glassmorphism Light Mode UI**: Designed using clean, translucent frosted-glass aesthetics native to **Jetpack Compose (Material 3)**.
- **🌤️ Dynamic Weather Header**: Real-time localized weather status badge directly on the main header.
---

## 🛠️ Tech Stack & Architecture

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose (Material 3)
- **Architecture Pattern:** MVVM (Model-View-ViewModel)
- **State Management:** Kotlin StateFlow & Coroutines
- **Graphics & Animation:** Compose `Canvas`, `PathEffect`, `InfiniteTransition`
- **Build System:** Gradle with Kotlin DSL (`.kts`)

---

## 📁 Project Structure

```text
com.ael.diverto/
├── ui/
│   ├── components/           # Reusable Glassmorphism Cards, Headers & Modal Sheets
│   │   ├── AppHeader.kt
│   │   ├── EnergyFlowCard.kt
│   │   ├── GlassCard.kt
│   │   └── StorageDetailSheet.kt
│   ├── screens/              # Core Application Screens & Navigation
│   │   ├── HomeScreen.kt
│   │   ├── SecondaryStorageScreen.kt
│   │   └── SplashScreen.kt
│   ├── theme/                # Color Schemes, Glass Borders & Typography
│   │   ├── Color.kt
│   │   └── Theme.kt
│   └── SmartDiverterViewModel.kt # Real-time energy simulation & StateFlow logic
└── MainActivity.kt           # Main Entry Point & Scaffold Layout
