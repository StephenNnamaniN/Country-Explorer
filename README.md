# 🌍 Country Explorer

**Country Explorer** is a modern Android application that provides detailed information about countries worldwide. It allows users to browse a list of countries, search for specific ones, and view in-depth details like flags, capitals, populations, and more.

The app is built using **Modern Android Development (MAD)** practices, ensuring a responsive UI, offline support, and clean code architecture.

---

## ✨ Features

- **Country List**: View all countries with their names, flags, and basic info.
- **Search & Filter**: Quickly find countries by name, country code (CCA2), or continent.
- **Detailed View**: Access comprehensive data including official names, sub-regions, area, languages, and population.
- **Offline Support**: Countries are cached locally using Room database, allowing you to browse even without an internet connection.
- **Clean UI**: Built with Jetpack Compose for a smooth and modern user experience.
- **Image Loading**: High-quality flag rendering using Coil.

---

## 🛠 Tech Stack & Libraries

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Architecture**: MVVM (Model-View-ViewModel) + Clean Architecture principles.
- **Dependency Injection**: [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Networking**: [Retrofit](https://square.github.io/retrofit/) & [Gson](https://github.com/google/gson)
- **Local Database**: [Room](https://developer.android.com/training/data-storage/room)
- **Image Loading**: [Coil](https://coil-kt.github.io/coil/)
- **Asynchronous Programming**: [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [Flow](https://kotlinlang.org/docs/flow.html)

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Ladybug or newer.
- JDK 17+.
- Android SDK 24+.

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Country-Explorer.git
   ```
2. Open the project in Android Studio.
3. Sync Project with Gradle Files.
4. Run the app on an emulator or physical device.

---

## 📡 API Reference

This app consumes the [RestCountries API](https://restcountries.com/).
- **Endpoint**: `https://restcountries.com/v3.1/all`
- **Fields used**: `name`, `flags`, `cca2`, `region`, `subregion`, `capital`, `population`, `area`, `languages`.



---

## 📸 Screenshots

| Country List | Search Filter | Country Details |
| :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/a6e569bc-1f08-42bc-8bd5-d5456b887804" width="200" /> | <img src="https://github.com/user-attachments/assets/deed3838-ccec-4cc9-aa17-ae31c8965bf0" width="200" /> | <img src="https://github.com/user-attachments/assets/50b72e10-d34a-4a3b-8d29-63a62b365598" width="200" /> |

---

## 🏗 Architecture

The project follows the **MVVM** pattern and is structured into layers:
- **`data`**: Handles API calls (Retrofit), Local Caching (Room), and Data Mapping.
- **`domain`**: Contains Business Logic, Use Cases, and Repository Interfaces.
- **`presentation`**: UI components (Jetpack Compose) and ViewModels.


