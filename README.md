📌 Employee Management System 💼

A complete Employee Management System developed using Java Swing and MySQL, designed to demonstrate real-world implementation of core and advanced Database Management System (DBMS) concepts.

🚀 🔥 Project Overview

This project provides a user-friendly interface to manage employee records efficiently. It allows performing all essential operations such as adding, updating, deleting, and viewing employee data with proper database connectivity.

The system is designed using normalized database structure (3NF) and integrates advanced MySQL concepts like:

🔁 Stored Procedures
⚡ Triggers
🔄 Cursors
🔗 Foreign Key Relationships
🛠️ Tech Stack
💻 Frontend
Java Swing (GUI)
🗄️ Backend
MySQL Database
🔗 Connectivity
JDBC (Java Database Connectivity)
🧰 Tools
IntelliJ IDEA
MySQL Workbench
🎯 Key Features

✔ User Login Authentication 🔐
✔ Add New Employee ➕
✔ Update Employee Details ✏️
✔ Delete Employee ❌
✔ View Employee Records 📊
✔ Database Normalization (3NF) 🧠
✔ Multi-table Structure 🔗
✔ Clean UI Design 🎨

🧠 Advanced DBMS Concepts Used
🔹 Normalization (Up to 3NF)

Database is structured into multiple tables to:

Reduce redundancy
Improve data integrity
Maintain efficient relationships

Tables used:

employee
job
education
employee_log
login
⚡ Trigger Implementation

Automatically logs deleted employee records:

CREATE TRIGGER after_employee_delete
AFTER DELETE ON employee
FOR EACH ROW
INSERT INTO employee_log(emp_id, action)
VALUES (OLD.emp_id, 'DELETED');

👉 Ensures audit tracking of data changes

🔁 Stored Procedure

Used for inserting employee data into multiple tables:

CALL add_employee(...);

👉 Improves performance and reusability

🔄 Cursor

Used to update employee salary row-by-row:

CALL increase_salary();

👉 Demonstrates iterative processing in SQL

🗂️ Database Design (ER Structure)
Employee (emp_id PK)
     |
     |---- Job (job_id PK, emp_id FK)
     |
     |---- Education (edu_id PK, emp_id FK)
📸 Screenshots

📌 Login Page
📌 Dashboard
📌 Add Employee Form
📌 View Employee Records

(Add your uploaded screenshots here)

🔗 CRUD Operations
Operation	Description
Create	Add new employee
Read	View employee details
Update	Modify employee data
Delete	Remove employee record
▶️ How to Run the Project

1️⃣ Clone the repository
2️⃣ Open in IntelliJ IDEA
3️⃣ Setup MySQL Database (db1)
4️⃣ Import SQL file (tables, trigger, procedures)
5️⃣ Update database credentials in conn.java
6️⃣ Run Splash.java

💯 Project Highlights

✔ Fully functional CRUD system
✔ Clean UI with Java Swing
✔ Strong backend using MySQL
✔ Implementation of advanced DBMS concepts
✔ Real-world application design

📈 Future Scope
🌐 Web-based version (Spring Boot / React)
🔐 Role-based authentication
📊 Analytics dashboard
☁️ Cloud database integration
👩‍💻 Author

Shruti Shinde
Second Year CSE Student 🎓
