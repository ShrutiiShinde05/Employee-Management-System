# 📘 Employee Management System using Java & MySQL

---

## 🏷️ 1. Project Title

**Employee Management System using Java and MySQL**

### 🛠️ Technology Stack

* **Frontend:** Java Swing 🖥️
* **Backend:** MySQL 🗄️
* **Connectivity:** JDBC 🔗
* **IDE:** IntelliJ IDEA 💻

---

## 📄 2. Abstract

The **Employee Management System** is a database-driven application designed to efficiently manage employee records within an organization. It enables users to perform essential operations such as **adding, updating, deleting, and viewing employee details**.

This project demonstrates key **Database Management System (DBMS)** concepts including:

* Normalization
* Relationships
* Triggers
* Stored Procedures
* Cursors

The system uses **Java Swing** for the graphical interface and **MySQL** as the backend database. Advanced SQL features enhance automation and efficiency:

* 🔁 Triggers automatically log deleted records
* ⚙️ Stored procedures handle multi-table insertion
* 🔄 Cursors perform bulk salary updates

✅ **Outcome:**
A reliable system that reduces redundancy, ensures data integrity, and reflects real-world database applications.

---

## 📚 3. Introduction

### 🔹 Background

Manual management of employee data is inefficient and prone to errors. Organizations need automated systems for better accuracy and speed.

### 🔹 Need of the System

* Reduce manual work ⏳
* Avoid data redundancy 📉
* Maintain data integrity 🔐
* Provide fast data access ⚡

### 🔹 Real-Life Applications

* HR Management Systems 🏢
* Employee Tracking Systems 📊
* Payroll Systems 💰

### 🔹 Scope

* Add, update, delete employees
* View employee records
* Maintain structured database
* Implement advanced DBMS concepts

---

## 📑 4. Software Requirement Specification (SRS)

### ✅ Functional Requirements

* Add employee record
* Update employee details
* Delete employee record
* View/Search employee data

### ⚙️ Non-Functional Requirements

#### 🔸 Performance

* Fast data retrieval using optimized SQL queries

#### 🔸 Security

* Login authentication system 🔑
* Use of Prepared Statements (prevents SQL Injection)

#### 🔸 Usability

* Simple and user-friendly GUI 🎯

---

### 💻 4.1 Hardware & Software Requirements

**Hardware:**

* Minimum 4GB RAM
* Intel i3 or higher

**Software:**

* OS: Windows 10/11
* Frontend: Java Swing
* Backend: MySQL
* Tools: IntelliJ IDEA, MySQL Workbench

---

## 🧩 5. Conceptual Design

### 📌 5.1 ER Diagram

👉 *(Insert ER Diagram here)*

### 🗃️ Relational Model

* Employee(emp_id, name, fname, dob, phone, email, address)
* Job(job_id, emp_id, designation, salary)
* Education(edu_id, emp_id, education)
* Login(username, password)
* Employee_Log(log_id, emp_id, action, timestamp)

---

### 🔄 Normalization

**1NF (First Normal Form)**

* All attributes are atomic
* No repeating groups

**2NF (Second Normal Form)**

* Removed partial dependency
* Salary moved to Job table

**3NF (Third Normal Form)**

* Removed transitive dependency
* Education stored separately

✅ **Result:** Reduced redundancy + Improved data integrity

---

### 🚀 Advanced DBMS Concepts Used

#### ✅ Trigger

Automatically logs deleted employees:

```sql
CREATE TRIGGER after_employee_delete
AFTER DELETE ON employee
FOR EACH ROW
INSERT INTO employee_log(emp_id, action)
VALUES (OLD.emp_id, 'DELETED');
```

#### ✅ Stored Procedure

```sql
CALL add_employee(...);
```

👉 Inserts data into multiple tables efficiently

#### ✅ Cursor

```sql
CALL increase_salary();
```

👉 Updates salaries row-by-row

---

## 🎨 6. Graphical User Interface (GUI)

### 🔐 Login Page

* Entry point of the system
* Validates user credentials via database
* Displays error for invalid login

👉 **Purpose:** Authentication & Security

---

### ➕ Add Employee Form

* Input fields: name, DOB, phone, email, salary, etc.
* Uses stored procedure for insertion
* Auto-generates Employee ID

👉 **Purpose:**

* Add new employee
* Maintain normalized structure

---

### 📊 View Employee

* Displays records in tabular format
* Uses SQL JOIN to combine multiple tables

👉 **Purpose:**

* Easy visualization
* Complete employee details

---

### ✏️ Update Employee

* Modify existing employee data
* Uses SQL UPDATE queries

👉 **Purpose:** Maintain accurate records

---

### ❌ Remove Employee

* Deletes employee using emp_id
* Trigger logs deletion automatically

👉 **Purpose:**

* Data removal
* Maintain transparency

---

## 💻 7. Source Code & Implementation

### 🔗 Database Connection

```java
Connection connection = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/db1", "root", "password");
```

---

## 🔄 CRUD Operations

### ✅ Create (Insert)

* Uses Stored Procedure
* Inserts into multiple tables

### ✅ Read (Retrieve)

* Uses JOIN queries
* Displays complete data

### ✅ Update (Modify)

* Uses PreparedStatement
* Prevents SQL Injection

### ✅ Delete (Remove)

* Uses DELETE query
* Trigger logs deletion

---

### 🔥 Bonus Features

#### Trigger

* Logs deleted records automatically

#### Cursor

* Bulk salary update

---

## 🧪 8. Testing

| Test Case       | Input      | Expected Output              | Status |
| --------------- | ---------- | ---------------------------- | ------ |
| Add Employee    | Valid Data | Record Inserted              | ✅ Pass |
| Delete Employee | emp_id     | Record Deleted + Log Created | ✅ Pass |
| Increase Salary | Procedure  | Salary Updated               | ✅ Pass |

---

## 🎯 9. Conclusion

The **Employee Management System** successfully demonstrates both **basic and advanced DBMS concepts**. The use of normalization ensures minimal redundancy and high data integrity.

Integration of **Java (JDBC) with MySQL** provides real-world application experience. Advanced features like **triggers, stored procedures, and cursors** enhance system performance and automation.

---

## 🔮 Future Scope

* 🌐 Develop web-based interface
* 🔐 Implement role-based authentication
* 💰 Add payroll system
* ☁️ Use cloud database

---

✨ **Overall:** This project is a complete, practical implementation of DBMS concepts with real-world relevance and strong technical foundation.
