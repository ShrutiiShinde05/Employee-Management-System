1.	Title of the Project
Project Title: Employee Management System using Java and MySQL
•	Technology Used (Frontend + Backend): Frontend: Java Swing 
•	Backend: MySQL 
•	Connectivity: JDBC 
•	IDE: IntelliJ IDEA 





2.	Abstract
The Employee Management System is a database-driven application developed to efficiently manage employee records in an organization. The system allows users to perform operations such as adding, updating, deleting, and viewing employee details. The main objective of this project is to demonstrate the use of Database Management System concepts such as normalization, relationships, triggers, stored procedures, and cursors.
The project is implemented using Java Swing for the user interface and MySQL as the backend database. Advanced SQL concepts like triggers are used to automatically log employee deletions, while stored procedures handle data insertion efficiently. A cursor is used to update employee salaries in bulk.
The expected outcome is a reliable and efficient system that minimizes data redundancy, ensures data integrity, and demonstrates real-world database applications.




3.	Introduction
🔹 Background
Managing employee data manually is time-consuming and error-prone. Organizations require automated systems to handle employee records efficiently.
🔹 Need of the System
•	Reduce manual work 
•	Avoid data redundancy 
•	Maintain data integrity 
•	Provide fast access to data 
🔹 Real-life Application
•	HR Management Systems 
•	Company employee tracking 
•	Payroll systems 
🔹 Scope
•	Add, update, delete employee 
•	View employee details 
•	Maintain structured database 
•	Demonstrate advanced DBMS concepts 




4.	Software Requirement Specification (SRS)
Functional Requirements
•	Add employee record 
•	Update employee details 
•	Delete employee record 
•	View/search employee data

Non-Functional Requirements
🔸 Performance
•	Fast data retrieval using SQL queries 
🔸 Security
•	Login authentication system 
•	Use of Prepared Statement (prevents SQL Injection) 
🔸 Usability
•	Simple and user-friendly GUI
 
4.1	Hardware & Software Requirements:
•  Hardware: 
•	4GB RAM minimum 
•	Intel i3 or higher 
•  OS: 
•	Windows 10 / 11 
•  Frontend: 
•	Java Swing 
•  Backend: 
•	MySQL 
•  Tools/IDE: 
•	IntelliJ IDEA 
•	MySQL Workbench


5.	Conceptual Design
5.1	ER Diagram:
(Insert ER Diagram)  


Relational Model:
•	Employee(emp_id, name, fname, dob, phone, email, address) 
•	Job(job_id, emp_id, designation, salary) 
•	Education(edu_id, emp_id, education) 
•	Login(username, password) 
•	Employee_Log(log_id, emp_id, action, timestamp) 


Normalization:
1NF
•	All attributes are atomic 
•	No repeating groups 
🔹 2NF
•	Removed partial dependency 
•	Salary moved to job table 
🔹 3NF
•	Removed transitive dependency 
•	Education stored separately 
👉 Result: Reduced redundancy + better data integrity

ADVANCED DBMS CONCEPTS USED
✅ Trigger
Automatically logs deleted employee:
CREATE TRIGGER after_employee_delete
AFTER DELETE ON employee
FOR EACH ROW
INSERT INTO employee_log(emp_id, action)
VALUES (OLD.emp_id, 'DELETED');
________________________________________
✅ Stored Procedure
CALL add_employee(...);
👉 Used for inserting data into multiple tables
________________________________________
✅ Cursor
CALL increase_salary();
👉 Used to update salary row-by-row





6.	Graphical User Interface (GUI)
Home Page
1. Login Page (Home Page)
Explanation:
The Login Page is the entry point of the Employee Management System. It allows authorized users to access the system by entering valid credentials (username and password). The data entered by the user is verified using the MySQL database through JDBC connectivity.
This page ensures security by restricting access to only authenticated users. It contains input fields for username and password, along with buttons for login and exit. If incorrect credentials are entered, an error message is displayed.
👉 Purpose:
•	Provides authentication 
•	Ensures system security 
•	Connects frontend with backend database 

 

 



🔹 Add Employee Form
•	Input employee details 
The Add Employee Form is used to insert new employee records into the system. It contains multiple input fields such as name, father’s name, date of birth, salary, address, phone number, email, designation, education, and Aadhaar number.
When the user clicks the "Add" button, the data is sent to the MySQL database using a stored procedure. This procedure inserts data into multiple tables (Employee, Job, Education), ensuring proper normalization and avoiding redundancy.
The Employee ID is automatically generated, ensuring uniqueness for each record.
👉 Purpose:
•	Add new employee details 
•	Use of stored procedure for insertion 
•	Maintain normalized database structure 
•	
 

 
🔹 View Employee
Explanation:
The View Employee screen displays all employee records in a tabular format. The data is fetched from multiple tables using SQL JOIN operations, combining information from Employee, Job, and Education tables.
This screen provides a clear and organized view of employee details such as name, designation, salary, and education.
👉 Purpose:
•	Display all employee records 
•	Use of JOIN queries 
•	Provide easy data visualization 

 
•	Displays employee data using table 
🔹 Update/Delete
•	Modify and remove record
   The Update Employee screen allows users to modify existing employee details. The system fetches the current data of the selected employee and displays it in editable fields.
•	After making changes, the updated data is stored back in the database using SQL UPDATE queries. This ensures that employee information remains accurate and up to date.
•	👉 Purpose:
•	Modify existing records 
•	Maintain data accuracy 
•	Implement UPDATE operation
Remove Employee Screen
Explanation:
The Remove Employee screen is used to delete employee records from the system. The user selects an employee ID, and upon confirmation, the record is deleted from the database.
A trigger is used in MySQL that automatically logs the deleted employee details into the Employee_Log table. This helps in tracking deletion activities and ensures accountability.
👉 Purpose:
•	Delete employee records 
•	Use of trigger for logging 
•	Maintain system transparency
The GUI is developed using Java Swing, providing a user-friendly interface for interacting with the MySQL database. All CRUD operations are integrated with backend logic ensuring smooth functionality.
•	 
•	 





7.	Source Code & Output Snapshot
Include:
-	Database connection code


Database Connection Code
Connection connection = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/db1", "root", "password");

  CRUD Example
CRUD OPERATIONS (Complete Explanation)
CRUD stands for:
•	C → Create (Insert Data) 
•	R → Read (Retrieve Data) 
•	U → Update (Modify Data) 
•	D → Delete (Remove Data) 
In this project, all CRUD operations are implemented using MySQL + Java (JDBC).
________________________________________
✅ 1. CREATE OPERATION (Insert Data)
👉 Used to add a new employee record into the database.
🔹 SQL (Stored Procedure Used)
CALL add_employee(103, 'Amit', 'Raj', '2002-02-02', 
'9999999999', 'amit@gmail.com', 'Delhi', 
'Engineer', 40000, 'BTech');
________________________________________
🔹 Java Code
CallableStatement cs = connection.prepareCall("{call add_employee(?,?,?,?,?,?,?,?,?,?)}");

cs.setInt(1, 103);
cs.setString(2, "Amit");
cs.setString(3, "Raj");
cs.setString(4, "2002-02-02");
cs.setString(5, "9999999999");
cs.setString(6, "amit@gmail.com");
cs.setString(7, "Delhi");
cs.setString(8, "Engineer");
cs.setDouble(9, 40000);
cs.setString(10, "BTech");

cs.execute();
________________________________________
🔹 Explanation
•	Uses Stored Procedure 
•	Inserts data into 3 tables: 
o	employee 
o	job 
o	education 
•	Ensures data consistency 
________________________________________
✅ 2. READ OPERATION (Retrieve Data)
👉 Used to display employee details.
________________________________________
🔹 SQL (JOIN Query)
SELECT e.emp_id, e.name, e.phone, j.designation, j.salary, ed.education
FROM employee e
JOIN job j ON e.emp_id = j.emp_id
JOIN education ed ON e.emp_id = ed.emp_id;
________________________________________
🔹 Java Code
PreparedStatement ps = connection.prepareStatement(
"SELECT e.emp_id, e.name, e.phone, j.designation, j.salary, ed.education " +
"FROM employee e " +
"JOIN job j ON e.emp_id = j.emp_id " +
"JOIN education ed ON e.emp_id = ed.emp_id"
);

ResultSet rs = ps.executeQuery();

while(rs.next()){
    System.out.println(rs.getString("name") + " " + rs.getString("salary"));
}
________________________________________
🔹 Explanation
•	Uses JOIN 
•	Fetches data from multiple tables 
•	Displays complete employee details 
________________________________________
✅ 3. UPDATE OPERATION (Modify Data)
👉 Used to update employee information.
________________________________________
🔹 SQL
UPDATE employee 
SET name='Amit Kumar', phone='8888888888' 
WHERE emp_id=103;

UPDATE job 
SET salary=45000, designation='Senior Engineer' 
WHERE emp_id=103;
________________________________________
🔹 Java Code
PreparedStatement ps1 = connection.prepareStatement(
"UPDATE employee SET name=?, phone=? WHERE emp_id=?"
);

ps1.setString(1, "Amit Kumar");
ps1.setString(2, "8888888888");
ps1.setInt(3, 103);
ps1.executeUpdate();

PreparedStatement ps2 = connection.prepareStatement(
"UPDATE job SET salary=?, designation=? WHERE emp_id=?"
);

ps2.setDouble(1, 45000);
ps2.setString(2, "Senior Engineer");
ps2.setInt(3, 103);
ps2.executeUpdate();
________________________________________
🔹 Explanation
•	Uses PreparedStatement 
•	Updates data in multiple tables 
•	Prevents SQL Injection 
________________________________________
✅ 4. DELETE OPERATION (Remove Data)
👉 Used to delete employee record.
________________________________________
🔹 SQL
DELETE FROM employee WHERE emp_id=103;
________________________________________
🔹 Java Code
PreparedStatement ps = connection.prepareStatement(
"DELETE FROM employee WHERE emp_id=?"
);

ps.setInt(1, 103);
ps.executeUpdate();
________________________________________
🔹 Explanation
•	Deletes employee record 
•	Due to ON DELETE CASCADE: 
o	job and education data also deleted automatically 
•	Trigger is activated 
________________________________________
🔥 BONUS: TRIGGER (Automatic Logging)
CREATE TRIGGER after_employee_delete
AFTER DELETE ON employee
FOR EACH ROW
INSERT INTO employee_log(emp_id, action)
VALUES (OLD.emp_id, 'DELETED');
👉 Automatically logs deleted records
________________________________________
🔄 BONUS: CURSOR (Bulk Update)
CALL increase_salary();
👉 Increases salary of all employees using cursor





Home page code

package employee.management.stystem;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image i2 = i1.getImage().getScaledInstance(1170,650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1170,650);
        add(image);


        setSize(1170,650);
        setLocation(200,50);
        setLayout(null);
        setVisible(true);

        try{
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Splash();
    }
}



main class code:

package employee.management.stystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {
    Main_class(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);

        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        img.add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.WHITE);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Employee();
                setVisible(false);
            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(440,370,150,40);
        rem.setForeground(Color.WHITE);
        rem.setBackground(Color.black);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });
        img.add(rem);

        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Main_class();
    }
}


connection code:

package employee.management.stystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection connection;
    Statement statement;

    public conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeemanagement?useSSL=false&serverTimezone=UTC",
                    "root",
                    "Shruti123"
            );

            statement = connection.createStatement();

            System.out.println("Connected Successfully ✅");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}  

8.	Testing Document (if any)

Test Case	Input	Expected Output	Actual Output	Status
Add Employee	Valid data	Record inserted	Success	Pass
Delete Employee	emp_id	Record deleted + log created	Success	Pass
Increase Salary	Call procedure	Salary increased	Success	Pass




9.	Conclusion
The Employee Management System successfully demonstrates the implementation of core and advanced DBMS concepts. The database is designed using normalization techniques to ensure minimal redundancy and high data integrity. Features such as triggers, stored procedures, and cursors enhance the functionality and efficiency of the system.
The project also integrates Java with MySQL using JDBC, providing a complete real-world application experience.
________________________________________
🔮 Future Scope
•	Add web-based interface 
•	Implement role-based login 
•	Add payroll system 
•	Use cloud database 

