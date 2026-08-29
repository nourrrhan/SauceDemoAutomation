# SauceDemo Test Automation

An automated testing framework built with **Katalon Studio** for testing [SauceDemo](https://www.saucedemo.com/), a demo e-commerce application. This project demonstrates end-to-end UI test automation practices including reusable test components, structured object repositories, and data-driven verification.

## 🎯 Project Goal

This framework is built progressively, sprint by sprint, to cover the majority of Katalon Studio's capabilities — from basic UI testing to CI/CD integration, API testing, and mobile automation.

## 🛠️ Tech Stack

- **Tool:** Katalon Studio
- **Language:** Groovy
- **Application Under Test:** [SauceDemo](https://www.saucedemo.com/)

## 📁 Project Structure

- **Test Cases/**
  - `Login/` — Login flow test cases
  - `Products/` — Product listing, sorting, and cart interaction
  - `Common/` — Reusable test cases (e.g., login helper)
  - `Cart/` — Cart content, item removal, and navigation (Complete)
  - `Checkout/` — Shipping info, order summary, and cancel flows (Complete)
- **Object Repository/** — Page element locators, organized by module
- **Profiles/** — Execution environment configurations

  
## ✅ Completed Modules

### Login Module (7 Test Cases)
- Valid login
- Invalid password / username
- Empty username / password / both
- Locked out user

### Products Module (8 Test Cases)
- Product page load verification
- Product count verification
- Sort by name (A-Z, Z-A)
- Sort by price (low-high, high-low)
- Add to cart / Remove from cart

### Cart Module (4 Test Cases)
- Cart page display verification (product name & price)
- Remove item from cart page
- Continue shopping navigation
- Proceed to checkout navigation

### Checkout Module (8 Test Cases)
- Fill shipping information (valid data)
- Empty field validation (first name, last name, zip code)
- Order summary verification (product match, price calculation)
- Order completion confirmation
- Cancel checkout (from shipping info page and from order summary page)
