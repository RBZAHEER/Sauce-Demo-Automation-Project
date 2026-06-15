# Selenium Hybrid Automation Framework

## 📌 Project Overview

This project is a Selenium Web Automation Framework developed using Java, TestNG, Maven, and Page Object Model (POM).  
The framework automates end-to-end UI test scenarios for a web application with support for data-driven testing, reporting, screenshots, and cross-browser execution.

The main goal of this framework is to create a scalable, maintainable, and reusable automation structure following industry-level best practices.

---

## 🚀 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- PageFactory
- Apache POI
- Extent Reports
- WebDriverManager
- Git/GitHub

---

## 🏗️ Framework Design

The framework follows Page Object Model architecture.

### Structure

src/test/java

├── base
│   └── BaseTest.java

├── pages
│   ├── LoginPage.java
│   ├── ProductsPage.java
│   ├── CartPage.java
│   └── CheckoutPage.java

├── tests
│   └── VerifyOrder.java

├── utils
│   ├── ConfigReader.java
│   ├── ExcelReader.java
│   ├── ScreenshotUtil.java
│   └── ExtentManager.java

├── listeners
│   └── TestListener.java


src/test/resources

├── config.properties
├── TestData.xlsx


---

## ✨ Features Implemented

### ✅ Page Object Model (POM)

Implemented POM design pattern to separate page locators and test logic, improving code readability and maintenance.

---

### ✅ PageFactory Implementation

Used Selenium PageFactory with:

- @FindBy annotations
- initElements()

for efficient web element initialization.

---

### ✅ Data Driven Testing

Implemented data driven framework using:

- Apache POI
- Excel files
- TestNG DataProvider

Test data is maintained externally without changing automation scripts.

---

### ✅ Configuration Management

Implemented ConfigReader utility to manage:

- Application URL
- Browser selection
- Environment configurations

using config.properties file.

Example:

browser=chrome

url=https://www.saucedemo.com/


---

### ✅ Cross Browser Testing

Framework supports multiple browsers:

- Chrome
- Firefox
- Edge

Browser can be changed from configuration file without modifying code.

---

### ✅ Screenshot Capture on Failure

Implemented automatic screenshot capturing using:

- TestNG ITestListener
- TakesScreenshot interface

Failed test screenshots are stored automatically.

---

### ✅ Extent HTML Reports

Integrated Extent Reports for detailed test execution reporting.

Report contains:

- Test status
- Failure reason
- Execution details

---

## 🔥 Automated Test Scenario

Implemented complete E-Commerce order workflow:

1. Launch application
2. Login using Excel test data
3. Validate Products page
4. Add product to cart
5. Verify cart product
6. Checkout product
7. Enter customer information
8. Complete order
9. Validate success message

---

## ▶️ How to Run

Clone repository:

git clone <repository-url>


Install dependencies:

mvn clean install


Run tests:

mvn test


---

## Future Enhancements

- Selenium Grid implementation
- Docker execution
- Jenkins CI/CD integration
- Parallel execution
- Retry failed test cases
- Advanced Selenium scenarios

---

## Author

Zaheer Mulani
