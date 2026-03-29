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