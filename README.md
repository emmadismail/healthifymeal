# HealthifyMeal

**Your healthy meals planning problems – Solved**

HealthifyMeal is an AI-powered Android app that generates personalized weekly meal plans, lets you order fresh meals directly from our kitchen, and even book 1:1 virtual consultations with certified dietitians. Built to cater to Pakistani tastes and ingredients, it turns meal planning into an effortless, magical experience.

---

## Table of Contents

- [Features](#features)  
- [Architecture](#architecture)  
- [Getting Started](#getting-started)  
  - [Prerequisites](#prerequisites)  
  - [Installation](#installation)  
- [Usage](#usage)  
- [Project Structure](#project-structure)  
- [Development & Build](#development--build)  
- [Testing](#testing)  
- [Contributors](#contributors)  
- [Acknowledgements](#acknowledgements)  
- [License](#license)  

---

## Features

1. **Personalized Meal Plans**  
   AI/ML-powered recommender (K-Nearest Neighbors) that considers your BMI, dietary restrictions, allergies, and goals (lose/gain weight).  
2. **On-Demand Expert**  
   Book a 1:1 virtual consultation with a certified dietitian.  
3. **Order Your Meals**  
   Weekly or one-off orders delivered fresh from our commercial kitchen.  
4. **Nutrition Info**  
   See calories, macros, and ingredient breakdown for every recipe.  
5. **Local Flavors**  
   Recipes and ingredients tailored for Pakistani tastes and availability.  

---

## Architecture

1. **Android Frontend**  
   − Java app (min. API 29).  
2. **Backend & ML**  
   − Flask service hosting a KNN model (scikit-learn) for menu generation.  
   − Firebase Realtime Database for user profiles, orders, appointments.  
3. **Delivery**  
   − Orders routed to our commercial kitchen; status tracked in admin console.  

---

## Getting Started

### Prerequisites

- Android Studio (Arctic Fox or later)  
- Java 11 (or as specified in `HealthifyMeal/gradle.properties`)  
- Android 10 (API 29) or higher device/emulator  
- Git  

### Installation

1. **Clone the repo**  
   ```bash
   git clone https://github.com/emmadismail/healthifymeal.git
