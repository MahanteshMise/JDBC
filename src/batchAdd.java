import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class batchAdd {
    public static void main(String[] args){
        Connection con = null;
        PreparedStatement stmt = null;
        String query = "insert into JDBC_FEB_2024.Employee111 values(?,?,?,?)";
        Scanner scan = new Scanner(System.in);
        String option;
        int[] updateCounts;

        try {
            con = CreateConnection.connect();
            stmt = con.prepareStatement(query);
            do{
                System.out.println("Enter the id,name,deignation and salary");
                stmt.setInt(1,scan.nextInt());
                stmt.setString(2,scan.next());
                stmt.setString(3,scan.next());
                stmt.setInt(4,scan.nextInt());
                stmt.addBatch();
                System.out.println("Would you like to insert a record? Please respond with Yes/No");
                option= scan.next();
            }while (option.equalsIgnoreCase("yes"));
            updateCounts = stmt.executeBatch();
            for(int x: updateCounts){
                System.out.print(x+" ");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            CloseConnection.closeConnection(null,stmt,con);
        }

    }
}
