import java.sql.*;
public class getTableInfo {
    public static void main(String[] args){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/JDBC_FEB_2024";
        String userName = "";
        String pwd = "";
        Statement stmt= null;
        String query = "select * from Employee111";
        ResultSet result = null;
        ResultSetMetaData rsmd = null;
        // Loading the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver has been loaded");
            // Creating a connection
            con = DriverManager.getConnection(url,userName,pwd);
            System.out.println("Connection has been established");
            stmt = con.createStatement();
            result = stmt.executeQuery(query);
            rsmd = result.getMetaData();
            int colCount = rsmd.getColumnCount();
            for(int i = 1;i<=colCount;i++){
                String colName = rsmd.getColumnName(i);
                String Type = rsmd.getColumnTypeName(i);
                System.out.println("Column # "+i +"\n\tColumnName :"+colName+"\tColumnType :"+Type);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            CloseConnection.closeConnection(result,stmt,con);
        }
    }
}
