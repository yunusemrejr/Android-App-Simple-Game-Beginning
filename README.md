# General Radar - Modern Android App

A modernized Android application for calculating mission outcomes based on enemy baseball bat radar detection.

## 🎯 Core Concept

The app maintains its original concept: users enter the number of enemy baseball bats detected by radar, and the app calculates whether they will win or lose the mission. The threshold is 10 bats - detecting 10 or more means victory!

## ✨ Modern Improvements

### Design & UI
- **Material Design 3**: Complete redesign with modern Material Design 3 components
- **Military-themed Color Palette**: Professional green/military color scheme with full dark mode support
- **Smooth Animations**: Fade-in animations, button press effects, rotating radar icon, and result animations
- **Card-based Layout**: Clean, organized interface with Material Cards
- **Responsive Design**: Optimized for different screen sizes

### Features Added
- **Statistics Tracking**: 
  - Total missions completed
  - Victory/defeat counts
  - Win rate percentage
  - Persistent storage using SharedPreferences
  - Reset statistics option

- **Input Validation**:
  - Empty input detection
  - Invalid number handling
  - Negative number validation
  - User-friendly error messages with Snackbar notifications

- **Enhanced UX**:
  - ViewBinding for type-safe view access
  - Smooth activity transitions
  - Visual feedback for all interactions
  - Color-coded results (green for victory, red for defeat)
  - Professional typography and spacing

### Technical Improvements
- **Updated Dependencies**:
  - Android SDK 34 (latest)
  - Material Design 3 (1.11.0)
  - ViewBinding enabled
  - Java 17 compatibility
  - Latest AndroidX libraries

- **Code Quality**:
  - Modern Android architecture patterns
  - Proper resource management
  - Memory leak prevention
  - Clean code structure

## 📱 App Structure

### MainActivity (Welcome Screen)
- Animated welcome card with app branding
- Rotating radar icon animation
- Material button with smooth press animation
- Fade-in entrance animations

### MainActivity2 (Mission Screen)
- Mission briefing card with classified information
- Radar input section with Material TextInputLayout
- Real-time result display with animations
- Statistics dashboard showing:
  - Total missions
  - Win rate percentage
  - Victories and defeats
  - Reset statistics button

## 🎨 Design Features

- **Color Scheme**: Military green theme with proper contrast ratios
- **Typography**: Sans-serif fonts with proper hierarchy
- **Icons**: Built-in Android icons for consistency
- **Spacing**: Proper padding and margins following Material Design guidelines
- **Elevation**: Card shadows for depth perception
- **Animations**: Smooth, professional animations throughout

## 🔧 Technical Details

- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)
- **Language**: Java
- **Architecture**: Modern Android with ViewBinding
- **Storage**: SharedPreferences for statistics persistence

## 📦 Build Information

- **Version**: 2.0
- **Package**: com.example.general
- **Build Tools**: Gradle 8.2.2

## 🚀 What's New in Version 2.0

1. Complete UI/UX redesign with Material Design 3
2. Statistics tracking system
3. Input validation and error handling
4. Smooth animations and transitions
5. Dark mode support
6. Modern color palette
7. Professional card-based layout
8. Enhanced user feedback
9. Updated to latest Android SDK and libraries
10. ViewBinding implementation for better performance

## 📄 License

MIT License - Copyright (c) 2022 YUNUS EMRE VURGUN

---

**Note**: The core concept remains unchanged - this is still the same General baseball bat radar calculator, just with a modern, professional interface and enhanced features!
