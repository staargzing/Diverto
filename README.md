# ☀️ Diverto — Zero-Waste Edge-AI Solar Energy Monitoring

> **"Empowering Sustainable Energy Efficiency with Real-Time Edge-AI Diversion & Minimalist Glassmorphism UI."**

**Diverto** is a modern Android mobile application built for smart solar energy ecosystems. Designed specifically to eliminate renewable energy waste, Diverto dynamically monitors and redirects excess solar power generation (*overproduction*) into secondary storage assets—such as water storage tanks, thermal water heaters, and portable batteries—maximizing operational efficiency and daily financial savings.

---

## ✨ Key Features

- **⚡ Live Energy Flow & Financial Counter**: Real-time simulation and tracking of diverted solar wattage ($W$) and daily accumulated cost savings ($Rp$) with active canvas line animations.
- **🤖 Edge-AI Autonomous Control**: Seamlessly toggle between **AUTO** (*Edge-AI Autonomous Diversion Mode*) and **MANUAL** (*Bypass Mode*).
- **💧 Secondary Storage Monitoring & Interactive Modal Sheets**:
    - **Water Tank (Toren Air)**: Custom wave canvas animation displaying real-time liquid percentage.
    - **Thermal Water Heater**: Pulsing temperature canvas indicator ($^\circ C$).
    - **Portable Battery Storage**: Charging progress animation showing reserve power capacity ($\%$).
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

## 📱 Application Screenshots & Preview

<table align="center">
  <tr>
    <td align="center" width="33%">
      <img src="https://github.com/user-attachments/assets/dbef2d1a-c681-4762-95bf-cbf53cafedd8" width="220" alt="Splash Screen"/><br />
      <b>1. Splash Screen</b>
    </td>
    <td align="center" width="33%">
      <img src="https://github.com/user-attachments/assets/3b7abf26-e867-4aaa-b68c-90c84cb3cebd" width="220" alt="Home Screen"/><br />
      <b>2. Home Screen</b>
    </td>
    <td align="center" width="33%">
      <img src="https://github.com/user-attachments/assets/4ede6ab3-92f0-4014-8444-1a06c6f215b4" width="220" alt="Secondary Storage Screen"/><br />
      <b>3. Secondary Storage</b>
    </td>
  </tr>
  <tr>
    <td align="center" width="33%">
      <img src="https://github.com/user-attachments/assets/accc8259-0a03-4191-8f93-2203934b91f0" width="220" alt="Detail Kapasitas Toren Air"/><br />
      <b>4. Detail Toren Air</b>
    </td>
    <td align="center" width="33%">
      <img src="https://github.com/user-attachments/assets/9dec0514-c3d0-41d0-b2dd-1a639c76e403" width="220" alt="Detail Water Heater"/><br />
      <b>5. Detail Water Heater</b>
    </td>
    <td align="center" width="33%">
      <img src="https://github.com/user-attachments/assets/cd198c56-b3c8-4475-9c59-3fa8df3150bb" width="220" alt="Detail Baterai Portabel"/><br />
      <b>6. Detail Baterai Portabel</b>
    </td>
  </tr>
</table>

### 🔍 Screen Details & Features

1. **Splash Screen**
   - Tampilan pembuka aplikasi dengan animasi *scaling* logo berkesan modern (*Overshoot Easing*).
   - Menampilkan identitas serta tagline utama: `"Zero-Waste Edge-AI Solar Monitoring"`.

2. **Home Screen**
   - **Smart Diverter Active Badge**: Mengindikasikan status ketersambungan alat serta *toggle switch* mode pengalihan (Edge-AI Autonomous vs. Manual).
   - **Estimasi Penghematan Hari Ini**: Menampilkan kalkulasi rupiah diselamatkan ($Rp$) dan daya teralihkan ($Watt$) secara real-time.
   - **Live Energy Flow**: Animasi *Canvas line stream* yang menggambarkan aliran energi dari Panel Surya ke Smart Diverter hingga ke Beban Sekunder.

3. **Secondary Storage Screen**
   - Daftar pemantauan *real-time* untuk 3 beban sekunder: Kapasitas Toren Air ($\%$), Suhu Water Heater ($^\circ C$), dan Estimasi Baterai Portabel ($\%$).
   - Dilengkapi *progress bar* visual sesuai status daya yang dialihkan.
   - Setiap kartu dapat diklik untuk membuka modal animasi interaktif.

4. **Detail Modal: Kapasitas Toren Air**
   - Menampilkan animasi *Canvas* gelombang air dinamis (*wave simulation*) yang bergerak secara simultan sesuai persentase air terisi.
   - Mengindikasikan aktivitas pengalihan energi ke pompa air.

5. **Detail Modal: Suhu Water Heater**
   - Indikator pemanas termal dengan animasi efek *pulsing* merah transparan yang merepresentasikan temperatur optimal ($60^\circ C$).
   - Menunjukkan pengalihan energi surya ke elemen pemanas termal.

6. **Detail Modal: Baterai Portabel**
   - Animasi pengisian daya baterai (*charging progress animation*) berbasis *Compose Canvas*.
   - Pemantauan kapasitas penyimpanan daya cadangan untuk penggunaan malam hari.
