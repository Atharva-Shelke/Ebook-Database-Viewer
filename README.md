# 📚 Ebook Database Viewer (Java Servlet + JDBC + H2 Database)

![Java](https://img.shields.io/badge/Java-8-orange)
![Servlet](https://img.shields.io/badge/Servlet-JavaEE-blue)
![JDBC](https://img.shields.io/badge/JDBC-Database-green)
![Database](https://img.shields.io/badge/Database-H2-darkblue)
![Server](https://img.shields.io/badge/Server-Tomcat%209-yellow)

A Java Servlet-based web application demonstrating **pure JDBC** database connectivity with an embedded **H2 Database**.

The application retrieves ebook records from the database and dynamically displays them in a styled HTML table using Java Servlets.

---

## ✨ Features

- Java Servlet based web application
- JDBC database connectivity
- Dynamic HTML table generation
- Embedded H2 database integration
- Externalized SQL queries loaded from SQL script
- Separation of SQL and application logic
- Apache Tomcat deployment
- Styled frontend using HTML & CSS
- Legacy MySQL JDBC implementation preserved for reference
- No external database installation required

---

## 🚀 Tech Stack

- Java 8
- Java Servlets
- JDBC
- H2 Database
- Apache Tomcat 9
- HTML5
- CSS3
- Eclipse / Spring Tool Suite (STS)

---

## 🗂️ Project Structure

```text
Ebook
├── src
│   └── main
│       ├── java
│       │   └── com/demo
│       │       ├── EbookServlet.java
│       │       ├── SqlLoader.java
│       │       └── DemoMySQLReference.java
│       │
│       ├── resources
│       │   └── sql
│       │       └── ebook.sql
│       │
│       └── webapp
│           ├── index.html
│           └── WEB-INF
│               ├── web.xml
│               └── lib
│                   ├── h2.jar
│                   ├── mysql-connector.jar
│                   └── protobuf-java.jar
│
├── screenshots
│   ├── home.png
│   └── table.png
│
└── README.md
```

---

## ⚙️ Database Information

### Current Implementation

This project currently uses an embedded **H2 Database** for easier execution and portability.

Database schema creation, sample data insertion, and query definitions are maintained in an external `ebook.sql` script. The application loads these named SQL statements at runtime using a custom SQL loader.

---

### Original Implementation

The original version of this project was developed using:

* MySQL
* MySQL Connector/J
* JDBC

The original implementation has been preserved in:

```text
DemoMySQLReference.java
```

This was done to preserve the original college experiment while improving portability and ease of execution.

---

## ▶️ Running the Application

### Prerequisites

- Java 8 or above
- Apache Tomcat 9
- Eclipse / STS

---

### Steps

#### 1. Import Project

```text
File → Import → Existing Projects into Workspace
```

---

#### 2. Configure Tomcat

Add Apache Tomcat 9 server in Eclipse / STS.

---

#### 3. Add Project to Server

```text
Right Click Server → Add and Remove
```

Add the `Ebook` project.

---

#### 4. Run Project

```text
Right Click Project → Run As → Run on Server
```

---

#### 5. Open in Browser

```text
http://localhost:8080/Ebook/
```

Click the **Show Database** button to display ebook records.

---

## 📄 Database Schema

```sql
CREATE TABLE ebook (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(100),
    price INT,
    quantity INT
);
```

---

## 📸 Output

The application displays ebook records in a styled HTML table containing:

* ID
* Book Title
* Author
* Price
* Quantity

### Home Page
![Home](screenshots/home.png)

### Database Table
![Database](screenshots/table.png)

---

## 📂 SQL Organization

SQL statements are maintained in a dedicated script:

```text
src/main/resources/sql/ebook.sql
```

Each query is identified using named query comments:

```sql
-- name: create_ebook_table
```
```sql
-- name: insert_ebook_records
```
```sql
-- name: find_all_ebooks
```

The application loads these queries dynamically at runtime, demonstrating a clean separation between SQL and Java application logic.

---

## 📖 Learning Objectives

This project demonstrates:

* Servlet lifecycle and request handling
* JDBC database operations
* Dynamic HTML generation using Java
* Database connectivity in Java web applications
* Externalizing SQL into reusable SQL scripts
* Working with embedded databases
* Deploying Java web applications on Apache Tomcat

---

## 📌 Note

This project is intentionally implemented using **pure JDBC instead of ORM frameworks like Hibernate/JPA** to demonstrate strong database connectivity and SQL fundamentals.