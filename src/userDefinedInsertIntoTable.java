import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class userDefinedInsertIntoTable {
    public static class insertIntoTable {
        public static void main(String[] args){
            Connection con = null;
            PreparedStatement pstmt =null;
            int res;
            Scanner scanInt = new Scanner(System.in);
            Scanner scanStr = new Scanner(System.in);
            System.out.println("Enter the Id of the Employee");
            int id = scanInt.nextInt();
            System.out.println("Enter the name of the Employee");
            String name = scanStr.next();
            System.out.println("Enter the department of the Employee");
            String department = scanStr.next();
            System.out.println("Enter the salary of the Employee");
            int salary = scanInt.nextInt();
            String q = "insert into JDBC_FEB_2024.Employee111(empId, empName, dept, salary)"+
                    " values(?,?,?,?)";
            try {
                con = CreateConnection.connect();
                pstmt = con.prepareStatement(q);
                pstmt.setInt(1,id);
                pstmt.setString(2,name);
                pstmt.setString(3,department);
                pstmt.setInt(4,salary);
                res = pstmt.executeUpdate();
                if(res != 0){
                    System.out.println(res+" row/s got affected");
                }
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            } finally {
                CloseConnection.closeConnection(null, pstmt,con);
            }
        }
    }

}
