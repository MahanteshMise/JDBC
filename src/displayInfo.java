import java.sql.*;

public class displayInfo {
    public static void main(String[] args) {
        // Checking whether driver is loaded.
        String url = "jdbc:mysql://localhost:3306/JDBC_FEB_2024";
        String un = "";
        String pwd = "";
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;
        int id ,salary;
        String name, department;

        try {
            con = CreateConnection.connect();
            stmt = con.createStatement();
            // Getting the Sql information from the tables
            res = stmt.executeQuery("SELECT * FROM JDBC_FEB_2024.Employee111");
            System.out.println("Statement is created "+res);

            while (res.next()) {
                id = res.getInt(1);
                name = res.getString(2);
                department = res.getString(3);
                salary = res.getInt(4);
                System.out.printf("%d %-9s %-10s %d\n",id,name,department,salary);
            }
        }
        catch(ClassNotFoundException | SQLException e ){
            e.printStackTrace();
            }
        finally {
            CloseConnection.closeConnection(res,stmt,con);
        }
    }
}