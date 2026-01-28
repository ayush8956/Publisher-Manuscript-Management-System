📘 Project Setup & Run Guide

This document provides the steps to set up, configure, and run the application locally, along with instructions to test the APIs.

🛠 Prerequisites

Ensure the following are installed:

Java 17+

Maven (or Maven Wrapper included in the project)

Git

Any IDE (IntelliJ IDEA / Eclipse / VS Code)

Postman

MySQL (or compatible relational database)

📥 Clone the Repository

Clone the project and open it in your preferred IDE:

git clone <your-github-repository-url>

⚙️ Application Configuration

Navigate to:

src/main/resources


Create a file named:

application.properties


Copy the structure from:

application.properties.example


Update the configuration values according to your local setup.

🔧 Sample application.properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/test_db
spring.datasource.username=root
spring.datasource.password=root

# JPA / Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Server Configuration
server.port=8080

▶️ Run the Application

From the project root directory, execute:

.\mvnw spring-boot:run


After successful startup, the application will be available at:

http://localhost:8080

🧪 API Testing

All APIs can be tested using Postman.

Use the appropriate HTTP methods (GET, POST, PUT, DELETE)

Request and response payloads are structured clearly

Endpoints are designed to be self-explanatory and easy to test

ℹ️ Important Note

Due to ongoing office responsibilities and limited time availability, interactive API documentation (such as Swagger/OpenAPI) has not been fully implemented in this version.

However, the core business logic, API functionality, and data handling have been implemented with clarity and correctness. Given additional time, API documentation and further enhancements can be added without impacting the existing design.
