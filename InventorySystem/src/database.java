import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

/*
install the .jar file at
C:\Program Files\MySQL\MySQL Connector J\mysql-connector-java-5.1.32-bin.jar.
  by going to File -> Program structure -> modules -> dependencies -> (press + button) ->
  (add jar file from file location)*/

public class database {

         static String url = "jdbc:mysql://127.0.0.1:3306/?user=root"; // location of mySQL file
         static String user = "root";
         static String password = "12669Rancho.";

    static void updateStock(String productID, String newStock){
        String sql_execute = "update our_company.product_1 set in_stock=\'"+newStock+"\' where product_ID="+productID;
        {
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement statemt = conn.createStatement();) {

                statemt.executeUpdate(sql_execute);
                System.out.println("Database updated successfully ");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } // try catch block
    }

    static void updateProductID(String currentProductID, String newProductID){
        String sql_execute = "update our_company.product_1 set product_ID=\'"+newProductID+"\' where product_ID="+currentProductID;
        {
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement statemt = conn.createStatement();) {

                statemt.executeUpdate(sql_execute);
                System.out.println("Database updated successfully ");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } // try catch block

    } //static void updateProductID


    static void updateProductName(String productName, String productID) {
        String sql_execute = "update our_company.product_1 set product_name=\'"+productName+"\' where product_ID="+productID;
        {
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement sttmt = conn.createStatement();) {

                sttmt.executeUpdate(sql_execute);
                System.out.println("Database updated successfully ");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } // try catch block
    } //updateProductName function



    public static void main(String[] args) {
        Connection myConn;

        {
            try {
                myConn = DriverManager.getConnection(url, user, password);
                Statement myStmt = myConn.createStatement();

                String sql = "select * from our_company.product_1"; // query statement
                ResultSet rs = myStmt.executeQuery(sql); //executes query

                while (rs.next())
                    System.out.println(rs.getString("product_name"));

            } catch (SQLException ex) {
                System.out.println("An error occurred while connecting MySQL databse");
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }

            updateProductName("james", "5");
            updateProductID("5", "3");
            updateStock("3", "20");

        } // try catch block

    } //public static void main(String[] args)
} // public class database