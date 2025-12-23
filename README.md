# Homework 7 – Parameterized Web Tests (JUnit 5 + Selenide)

This project contains automated web tests written as part of Homework 7.

## 🔧 Technologies
- Java 17
- JUnit 5
- Selenide
- Gradle

## 🌐 Tested websites
- https://staff.am
- https://meknark.am

## 🧪 Implemented tests
The project demonstrates **parameterized tests** using different data providers:

### 1️⃣ `@EnumSource`
- Language switch tests (EN / HY)
- Verification that page content changes after language selection

### 2️⃣ `@ValueSource`
- Main action buttons visibility and clickability
  - "Learn more"
  - "Become a donor"

### 3️⃣ `@MethodSource`
- Service cards visibility test
  - Let us manage YouTube
  - Project and event management
  - Translations
  - Creating and editing of videos
  - Other

## ▶️ How to run tests
Run all tests using Gradle:
```bash
./gradlew clean test
