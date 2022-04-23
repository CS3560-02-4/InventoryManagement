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

    public static void main(String[] args){
    String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
    String user = "root";
    String password = "admin";
    Connection myConn;

    {
        try {
            myConn = DriverManager.getConnection(url,user,password);
            if (myConn != null) {
                System.out.println("Successfully connected to MySQL database test");
            }

            //  ---INSERT STATEMENT---
            String sql = "insert into our_company.users (user_ID, first_name, last_name, email_ID, password, last_login_date, access) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = myConn.prepareStatement(sql);
            statement.setInt(1, 1);
            statement.setString(2, "Bill");
            statement.setString(3, "Gates");
            statement.setString(4, "bg@gmail.com");
            statement.setString(5, "bgpass");
            statement.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
            statement.setInt(7, 1);

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("New user inserted successfully!");
            }

            //  ---SELECT STATEMENT---
            sql = "select * from our_company.users";
            Statement myStmt = myConn.createStatement();
            ResultSet rs = myStmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String email = rs.getString(4);
                String pass = rs.getString(5);

                String output = "User #%d: %s - %s - %s - %s";
                System.out.println(String.format(output, id, firstName, lastName, email, pass));
            }



        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
                            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }


}
}