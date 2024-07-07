import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

public class CloseConnection {
    public static void closeConnection(ResultSet res, Statement stmt, Connection con) {
        try {
            if(res!=null){
                res.close();
                System.out.println("ResultSet closed");
            }
            if(stmt!=null){
                stmt.close();
                System.out.println("Statement closed");
            }
            if(con != null){
                con.close();
                System.out.println("Connection closed");
            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
