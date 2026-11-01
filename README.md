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

## 📱 Screenshots 
1. Splash Screen
<img width="1080" height="2400" alt="image" src="https://github.com/user-attachments/assets/ba11ff36-2097-4088-b4eb-7a3e53ef3a2f" />
2. Home Page
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/df839040-a9fb-4b8d-8301-787fb6c4b50c" />
3. Secondary Storage Page
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/a8cec808-f14e-4919-a836-a6211a40cca2" />
4. Water Capacity Storage Page
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/90e674fb-1385-4a80-9f3d-0e772ac3785e" />
5. Water Heater Temperature Detail Page
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/d19158ac-a998-40c4-b3b2-77705fde70a2" />
6. Portable Battery Detail Page
<img width="720" height="1600" alt="image" src="https://github.com/user-attachments/assets/2603f488-04cb-474c-bb76-c27bf714577d" />


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
