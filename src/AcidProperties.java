import java.sql.*;
import java.util.Scanner;

public class AcidProperties {
    private static boolean transaction(Connection con){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the sender and receiver details");
        String name1 = scan.next();
        String name2 = scan.next();
        int amount = scan.nextInt();
        int eQ1Result = 0;
        int eQ2Result = 0;
        try {
            eQ1Result = AcidProperties.updateAmount(name1,amount,con);
            eQ2Result = AcidProperties.updateAmount(name2,-amount,con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isConfirm(eQ1Result,eQ2Result);
    }
    private static int updateAmount(String sender,int amount,Connection con) throws SQLException {
        String query = "update acidTable111 set balance=balance-? where name = ?";
        PreparedStatement preparedStatement = null;
        try {
            PreparedStatement prepareStatement = con.prepareStatement(query);
            prepareStatement.setInt(1,amount);
            prepareStatement.setString(2,sender);
            return prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static boolean isConfirm(int i,int j){
        System.out.println("Do you want to confirm the transaction");
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();
        if(choice.equalsIgnoreCase("yes")){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/JDBC_FEB_2024";
        String userName = "root";
        String pwd = "mahantesh";

        try {
            //Loading the driver.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is loaded");
            //Establishing the connection with the database.
            con = DriverManager.getConnection(url,userName,pwd);
            // Setting the autocommit feature to false
            con.setAutoCommit(false);
            boolean transaction = AcidProperties.transaction(con);
            if(transaction){
                con.commit();
            }else{
                con.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            CloseConnection.closeConnection(null,null,con);
        }
    }
}
