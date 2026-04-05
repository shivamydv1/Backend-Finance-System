# Backend-Finance-System
This project is a backend system for a finance dashboard that manages users, financial records, and provides summary analytics with role-based access control.

💰 Finance Data Processing and Access Control Backend

The system is designed to demonstrate backend architecture, API design, data handling, and access control using Spring Boot.

🧠 Features
👤 User Management
Create users
Assign roles (ADMIN, ANALYST, VIEWER)
Activate/Deactivate users
Role-based access control
💰 Financial Records
Create financial records (income/expense)
View all records
Update and delete records
Filter records by category and type
📊 Dashboard Analytics
Total income
Total expenses
Net balance
🔐 Security
Role-based authorization using Spring Security
Restricted endpoints using @PreAuthorize
⚙️ Validation & Error Handling
Input validation using annotations
Global exception handling
🏗️ Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database
Controller: Handles HTTP requests
Service: Contains business logic
Repository: Handles database operations
Entity: Represents database tables
🗂️ Project Structure
com.financeapp
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── dto
 ├── security
 ├── exception
 └── config
🛠️ Tech Stack
Java
Spring Boot
Spring Security
Spring Data JPA
MySQL / H2 Database
Maven
🧪 API Endpoints
👤 User APIs
Method	Endpoint	Description
POST	/api/users	Create user (ADMIN)
GET	/api/users	Get all users (ADMIN)
PUT	/api/users/{id}/status	Update user status
💰 Financial APIs
Method	Endpoint	Description
POST	/api/finance	Create record (ADMIN)
GET	/api/finance	Get all records
PUT	/api/finance/{id}	Update record (ADMIN)
DELETE	/api/finance/{id}	Delete record (ADMIN)
🔍 Filter API
Method	Endpoint
GET	/api/finance/filter?category=Food
GET	/api/finance/filter?type=INCOME
📊 Summary API
Method	Endpoint
GET	/api/finance/summary
🔐 Access Control
Role	Permissions
ADMIN	Full access
ANALYST	View + analytics
VIEWER	Read-only
🗄️ Database Configuration
MySQL (Recommended)
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
H2 (Optional)
spring.datasource.url=jdbc:h2:mem:finance_db
spring.h2.console.enabled=true
▶️ How to Run
Clone the repository
Configure database in application.properties
Run the Spring Boot application
Use Postman to test APIs
🧪 Testing
APIs tested using Postman
Includes role-based access testing
CRUD + filtering + summary verified
📌 Assumptions
Authentication is basic (in-memory)
Roles are assigned at user creation
No frontend is included
Simplified security for demonstration

💡 Key Highlights
Clean layered architecture
Role-based access control
Aggregation APIs for analytics
Proper validation and error handling
👨‍💻 Author

Shivam Yadav



This project focuses on backend design, clean implementation, and logical structure rather than production-level complexity.
