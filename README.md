# 🛒 Thoga Kade (POS System)

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![JavaFX](https://img.shields.io/badge/JavaFX-UI-blue)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![Architecture](https://img.shields.io/badge/Architecture-Layered-green)

**Thoga Kade** is a standalone Point of Sale (POS) application designed to manage the day-to-day operations of a wholesale or retail grocery store. This project demonstrates the implementation of **Layered Architecture** (Controller, BO, DAO, DTO) to separate business logic from data access.

## 🚀 Key Features

- **👥 Customer Management:** Add, update, search, and delete customer details.
- **📦 Item Management:** Manage inventory, update stock levels, and set unit prices.
- **🛒 Place Order:** Real-time order processing with automated total calculation and stock reduction.
- **📜 Order History:** View past transactions and order details.
- **📊 Reports:** Generate sales reports and inventory status (optional if you added Jasper).

## 🛠️ Tech Stack

- **Language:** Java (JDK 8 / 11 / 17)
- **UI Framework:** JavaFX (FXML)
- **Database:** MySQL
- **Design Pattern:** MVC / Layered Architecture (DAO Pattern)
- **Build Tool:** Maven (or standard Ant build)

## 📂 Project Structure

```text
Thoga-Kade/
├── src/
│   ├── controller/       # UI Controllers (JavaFX)
│   ├── view/             # FXML files
│   ├── model/            # DTOs (Data Transfer Objects)
│   ├── bo/               # Business Objects (Logic)
│   ├── dao/              # Data Access Objects (SQL queries)
│   ├── db/               # Database Connection (Singleton)
│   └── AppInitializer.java
└── README.md             # Documentation
