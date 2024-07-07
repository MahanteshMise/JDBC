import java.sql.*;

public class CreateConnection {
    private static String url = "jdbc:mysql://localhost:3306/JDBC_FEB_2024";
    private static String un = "";
    private static String pwd = "";
    private static Connection con = null;
    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver is loaded");
        con = DriverManager.getConnection(url, un, pwd);
        System.out.println("Connection to DB Established " + con);
        return con;
    }
}
