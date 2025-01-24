# Android App: User Info App

## Overview
This is an Android application designed to demonstrate a simple user data management workflow. The app consists of two screens and utilizes modern Android development frameworks and tools. The application is built using Kotlin and follows the principles of Clean Architecture with an MVI design pattern for enhanced code quality and maintainability.

---

## Features
1. **Screen 1: User Input Form**
   - Purpose: Allows the user to input their details, including:
     - Name
     - Age
     - Job Title
     - Gender
   - Saves the entered data locally in a database.

2. **Screen 2: Display User Data**
   - Purpose: Retrieves and displays the saved user data from the local database in a structured and user-friendly manner.

---

## Technical Details
- **Framework**: Android Native Framework
- **Language**: Kotlin
- **Database**: Room (for local data storage)
- **Architecture**: Clean Architecture
- **Design Pattern**: MVI (Model-View-Intent)
- **UI Toolkit**: Jetpack Compose (for building the UI)
- **State Management**: Flow (for reactive programming)
- **Navigation**: Jetpack Navigation Component (for seamless screen transitions)

---

## Project Structure
The project is structured to promote separation of concerns and maintainability:

1. **Presentation Layer**
   - Handles UI using Jetpack Compose.
   - State and intent management using MVI.

2. **Domain Layer**
   - Contains use cases and business logic.

3. **Data Layer**
   - Handles data persistence using Room.
   - Provides a repository interface for data access.

---

## Installation
1. Clone the repository:
   ```bash
   git clone <repository_url>
   ```
2. Open the project in Android Studio.
3. Build and run the project on an emulator or a physical device.

---

## How It Works
1. **First Screen:**
   - User enters their name, age, job title, and gender.
   - Data is validated and saved to the local Room database.

2. **Second Screen:**
   - Fetches the saved user data using Flow and displays it dynamically.
---

## Development Notes

### `database-v2-migration` Branch
This branch demonstrates how to update the Room database schema to version 2, handle data migrations, and test the migration process. 

#### Key Updates
1. **Database Version Upgrade**:
   - Upgraded the database to version 2 with schema changes.
   - Included a migration script to ensure data integrity during the upgrade.

2. **Migration Testing**:
   - Added tests using `MigrationTestHelper` to verify the database migration.
   - Demonstrates how to insert sample data, perform migration, and validate the resulting schema.

#### Purpose
- This branch is created solely to share a practical example of database migration and testing.
- **Note**: This branch will not be merged into the main branch and is intended for learning and demonstration purposes.

#### How to Use
1. Switch to the branch:
   ```bash
   git checkout database-v2-migration
   ```
2. Review the migration code and test files.
3. Run the tests to understand how migration and validation are implemented:
   ```bash
   ./gradlew connectedAndroidTest
   ```
---

## License
This project is licensed under the MIT License. See the LICENSE file for details.

