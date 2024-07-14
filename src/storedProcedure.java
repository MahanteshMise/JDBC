import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;

public class storedProcedure {
    public static void main(String[] args){

        // Loading the Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/JDBC_FEB_2024";
            String userName = "";
            String password = "";
            Connection con = DriverManager.getConnection(url,userName,password);
            CallableStatement prepareCall = con.prepareCall("{call emp_count_on_dept(?,?)}");
            System.out.println("Enter the Dept Name");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            prepareCall.setString(1,name);
            // Getting a register ready
            prepareCall.registerOutParameter(2, Types.INTEGER);
            //Executing the procedure
            prepareCall.execute();
            int i = prepareCall.getInt(2);
            System.out.println("The " +name+" has "+i+" count values in the Employee table." );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
