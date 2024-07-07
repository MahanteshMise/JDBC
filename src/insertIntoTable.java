import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class insertIntoTable {
    public static void main(String[] args){
        Connection con = null;
        Statement stmt =null;
        int res;
        String q = "insert into JDBC_FEB_2024.Employee111 values(5,'Megha','Developer',75000)";
        try {
            con = CreateConnection.connect();
            stmt = con.prepareStatement(q);
            res = stmt.executeUpdate(q);
            if(res != 0){
                System.out.println(res+" row/s got affected");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CloseConnection.closeConnection(null,stmt,con);
        }
    }
}
