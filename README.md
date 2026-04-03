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
| <img src="https://storage.googleapis.com/static.mimir.prd.monorepo.google.com/9782806935147551062/1.png" width="200" /> | <img src="https://storage.googleapis.com/static.mimir.prd.monorepo.google.com/9782806935147551062/2.png" width="200" /> | <img src="https://storage.googleapis.com/static.mimir.prd.monorepo.google.com/9782806935147551062/0.png" width="200" /> |

---

## 🏗 Architecture

The project follows the **MVVM** pattern and is structured into layers:
- **`data`**: Handles API calls (Retrofit), Local Caching (Room), and Data Mapping.
- **`domain`**: Contains Business Logic, Use Cases, and Repository Interfaces.
- **`presentation`**: UI components (Jetpack Compose) and ViewModels.

---

## 📄 License

```text
Copyright 2024 Nnamani Stephen

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
