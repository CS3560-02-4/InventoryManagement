import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class database {

    public static void main(String[] args){
    String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
    String user = "root";
    String password = "12669Rancho.";
    Connection myConn;

    {
        try {
            myConn = DriverManager.getConnection(url,user,password);
            Statement myStmt = myConn.createStatement();
            String sql = "select * from our_company.product_1";
            ResultSet rs = myStmt.executeQuery(sql);

            if (myConn != null) {
                System.out.println("Successfully connected to MySQL database test yayyy");
            }

            while (rs.next())

                System.out.println(rs.getString( "product_name"));


        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
                            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }


}
}