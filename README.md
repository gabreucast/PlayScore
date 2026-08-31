# [EN] PlayScore

## About the Project

PlayScore is an Android application designed to simplify score tracking during Truco matches. Truco is a popular card game widely played across several Latin American countries, especially in Argentina, Brazil, Uruguay, and Paraguay.
The app allows users to keep track of points for two players or teams, record victories, and view match history through a simple and intuitive interface.

This project was developed as part of the Android learning journey using Kotlin and modern Android development practices.

<img width="276" height="600" alt="imagem 1" src="https://github.com/user-attachments/assets/84da1eb7-fc23-4c56-b051-cfb68edc4cbc" />
<img width="276" height="600" alt="imagem 4" src="https://github.com/user-attachments/assets/6a621896-d775-401d-90d1-f3185f99f738" />
<br>
<img width="276" height="600" alt="imagem 2" src="https://github.com/user-attachments/assets/4e7556b5-816a-400e-af13-38fe236a1c4e" />
<img width="276" height="600" alt="imagem 3" src="https://github.com/user-attachments/assets/80a52c01-10c0-46e8-a9be-649584bba59a" />






---

## Features

## Design Inspiration

PlayScore's color scheme was inspired by the traditional colors of UTFPR (Federal University of Technology – Paraná), where I am currently pursuing a postgraduate specialization in Mobile Application Development. The colors were adapted to provide a familiar visual identity while ensuring good usability and readability.

### Score Tracking

* Add points to each player using quick action buttons (+1, +3, +6, +9, and +12).
* Real-time score updates.
* Reset the current match score without affecting the win history.

### Player Management

* Customize player or team names.
* Display default names when no custom names are configured.
* Temporarily preserve player names during configuration changes.

### Winner Detection

* Automatically detect when a player reaches the winning score.
* Display a winner dialog when a match ends.
* Automatically register victories in the scoring history.

### Win History

* Track the total number of wins for each player.
* Clear the win history when desired.
* Automatically update the history after each completed match.

### Multilingual Support

The application supports multiple languages:

* English
* Portuguese
* Spanish

Translations are managed using Android resource files.

---

## Technologies Used

### Programming Language

* Kotlin

### Platform

* Android SDK

### Android Components

* Activities
* Intents
* Activity Result API
* View Binding
* AlertDialog
* Toast
* onSaveInstanceState
* ConstraintLayout
* ScrollView
* Material Components

### Testing

* JUnit
* Android Instrumented Tests

---

## Concepts Applied

During development, several important Android concepts were implemented:

* Activity navigation
* Data transfer using Intents
* Activity result handling
* Activity lifecycle management
* State persistence with onSaveInstanceState
* Internationalization (i18n)
* Resource organization (Strings, Colors, Drawables, and Layouts)
* Material Design UI customization

---

## Application Structure

### MainActivity

Main screen responsible for match management:

* Score display
* Point control
* Winner detection
* Access to additional features

### EditName Activity

Screen used to configure player or team names.

### ScoreHistory Activity

Screen responsible for displaying the accumulated win history.

---

## Future Improvements

Potential features planned for future versions:

* Data persistence using SharedPreferences
* Permanent history between app sessions
* Detailed match statistics
* Support for different Truco rule variations
* Light and dark themes
* Animations and UI enhancements
* Match result export

---

## Educational Purpose

This project was created to practice fundamental Android development concepts using Kotlin while applying modern development practices, state management, activity communication, and user interface design.

---
