import java.sql.*;
import java.util.Scanner;

public class deleteARecord {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/JDBC_FEB_2024";
        String username = "";
        String pwd = "";
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "DELETE FROM JDBC_FEB_2024.Employee111 WHERE empId = ?";


        int userId;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the userId whose record you want to delete");
        userId = scan.nextInt();
        try {
            // Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver has been loaded");
            // Creating a connection
            con = DriverManager.getConnection(url, username, pwd);
            System.out.println("Connection has been established");
            pstmt = con.prepareStatement(query);
            // Referencing a prepared statement
            pstmt.setInt(1, userId);
            int i = pstmt.executeUpdate();
            if (i != 0) {
                System.out.println(i + " row/rows have been deleted");
            }
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
}

