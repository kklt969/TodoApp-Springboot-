# 📝 Spring Boot Todo WebApp (with Dockerized MySQL & AI Chatbot Integration)

**Start Date:** March 29  
**Purpose:** A full-stack CRUD web application built as a learning project. Features Spring Boot, JSP/Servlets frontend, Spring Security, Dockerized MySQL, and planned AI chatbot integration.

---

## ✅ Features

- 🔐 Log in / Log out (Spring Security)
- ➕ Add a Todo
- ✔️ Mark Todo as Done
- ❌ Delete Todo
- 🧠 Coming soon: AI Chatbot Integration

---

## 🧱 Architecture & Design

| Layer      | Tech Stack                                |
|------------|--------------------------------------------|
| Frontend   | JSP/Servlets, HTML, CSS (Bootstrap), JS (jQuery) |
| Backend    | Java Spring Boot                          |
| Database   | MySQL (Dockerized)                        |
| Security   | Spring Security                           |
| Container  | Docker (MySQL container)                  |

---

## 🛠️ Installation & Setup

### Prerequisites
- Java 17+
- Docker
- Maven

### 1. Clone the repository
```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
cd YOUR_REPO_NAME

2. Start MySQL with Docker

docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=admin123 \
-e MYSQL_DATABASE=todo_db -p 3306:3306 -d mysql:latest

3. Configure application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=admin123
spring.jpa.hibernate.ddl-auto=update

spring.mvc.prefix=/WEB-INF/jsp/
spring.mvc.suffix=.jsp
spring.mvc.format.date=yyyy-MM-dd
logging.level.com.springboot.webapp-kklt=debug

4. Run the Spring Boot Application

mvn spring-boot:run

🔐 Authentication & Security

    Spring Security provides the login page

    Username/password configured in SecurityConfig

    Authenticated user can be accessed via:

Authentication auth = SecurityContextHolder.getContext().getAuthentication();
String username = auth.getName();

    Passwords are encoded using:

Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

📦 Dependencies (from pom.xml)

    Spring Boot Starter Web / Data JPA / Security / Validation / Test

    JSP support: tomcat-embed-jasper, JSTL API

    Dev Tools for hot reload

    WebJars for Bootstrap and jQuery

    MySQL Connector

🗂️ Project Branching Strategy
Branch	Description
iteration-1	Todo entity class & controller setup
iteration-2	Spring Security configuration
main	Stable production-ready version
🐳 Docker Setup (MySQL)

You can manage your MySQL container using Docker:

docker pull mysql:latest
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=admin123 \
-e MYSQL_DATABASE=todo_db -p 3306:3306 -d mysql:latest

🧼 Tip: Use a .dockerignore to exclude local builds and logs.
💡 Future Enhancements

    🤖 AI Chatbot Integration

    ✅ User registration flow

    📱 Responsive UI with Bootstrap 5

    🗃️ Admin panel

