import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User extends javax.swing.JFrame {

    static Connection myConn;
    private boolean newUser = true;

    public User() {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        initComponents();
        this.setLocationRelativeTo(null);
        addUserFrame.setLocationRelativeTo(null);
        this.setVisible(true);

        //Initialize User Table
        updateUserTable();

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addUserFrame = new JFrame();
        uConfirmButton = new JButton();
        uCancelButton = new JButton();
        UserFrame = new JPanel();
        updateUserButton = new JButton();
        addUserButton = new JButton();
        removeUserButton = new JButton();
        UserBackButton = new JButton();
        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        UserTable = new JTable();
        searchField = new JTextField();
        searchButton = new JButton();
        uFirstField = new JTextField();
        uLastField = new JTextField();
        uEmailField = new JTextField();
        uAccessField = new JTextField();
        uPasswordField = new JPasswordField();
        uFirstText = new JLabel();
        uLastText = new JLabel();
        uEmailText = new JLabel();
        uAccessText = new JLabel();
        uPasswordText = new JLabel();
        userLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Management");
        setResizable(false);

        UserFrame.setPreferredSize(new Dimension(600, 500));

        updateUserButton.setText("Update User");
        updateUserButton.setFocusPainted(false);
        updateUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                updateUserButtonActionPerformed(evt);
            }
        });

        addUserButton.setText("Add User");
        addUserButton.setFocusPainted(false);
        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        addUserFrame.setTitle("Add User");
        addUserFrame.setResizable(false);
        addUserFrame.setMinimumSize(new Dimension(370, 300));
        uFirstText.setText("First Name:");
        uLastText.setText("Last Name:");
        uEmailText.setText("Email:");
        uPasswordText.setText("Password:");
        uAccessText.setText("Access:");
        uConfirmButton.setText("Confirm");
        uConfirmButton.setFocusPainted(false);
        uConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uConfirmButtonActionPerformed(evt);
            }
        });
        uCancelButton.setText("Cancel");
        uCancelButton.setFocusPainted(false);
        uCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addUserFrameLayout = new javax.swing.GroupLayout(addUserFrame.getContentPane());
        addUserFrame.getContentPane().setLayout(addUserFrameLayout);
        addUserFrameLayout.setHorizontalGroup(
                addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addUserFrameLayout.createSequentialGroup()
                                .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(addUserFrameLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addUserFrameLayout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(uConfirmButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(uCancelButton))
                                                        .addGroup(addUserFrameLayout.createSequentialGroup()
                                                                .addGap(14,14,14)
                                                                .addComponent(uLastText)
                                                                .addGap(4,4,4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(uLastField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 26, Short.MAX_VALUE))
                                                )
                                        )
                                        .addGroup(addUserFrameLayout.createSequentialGroup()
                                                .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(addUserFrameLayout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(uFirstText)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(uFirstField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(addUserFrameLayout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(uAccessText)
                                                                                .addComponent(uPasswordText))
                                                                        .addComponent(uEmailText, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(uPasswordField)
                                                                                .addComponent(uAccessField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(uEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        addUserFrameLayout.setVerticalGroup(
                addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(addUserFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGap(30,30,30)
                                .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(uFirstField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(uFirstText))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(uLastText)
                                        .addComponent(uLastField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(uEmailText)
                                        .addComponent(uEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(uPasswordText)
                                        .addComponent(uPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(uAccessText)
                                        .addComponent(uAccessField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addGroup(addUserFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(uConfirmButton)
                                        .addComponent(uCancelButton))
                                .addContainerGap())
        );


        removeUserButton.setText("Remove User");
        removeUserButton.setFocusPainted(false);
        removeUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeUserButtonActionPerformed(evt);
            }
        });

        UserBackButton.setText("Back");
        UserBackButton.setFocusPainted(false);
        UserBackButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                oBackButtonActionPerformed(evt);
            }
        });

        UserTable.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String [] {
                        "User ID", "First Name", "Last Name", "Email", "Password", "Last Login Date", "Access"
                }
        ));
        UserTable.setDefaultEditor(Object.class, null);
        jScrollPane2.setViewportView(UserTable);

        searchButton.setText("Search");
        userLabel.setText("Hello " + database.returnVal("users", "user_id", LoginPage.user, "first_name") + " " + database.returnVal("users", "user_id", LoginPage.user, "last_name") + " [Employee ID: " + LoginPage.user + "]");

        GroupLayout UserFrameLayout = new GroupLayout(UserFrame);
        UserFrame.setLayout(UserFrameLayout);
        UserFrameLayout.setHorizontalGroup(
                UserFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(UserFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(UserFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                                        .addGroup(UserFrameLayout.createSequentialGroup()
                                                .addGroup(UserFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(removeUserButton)
                                                        .addComponent(updateUserButton)
                                                        .addComponent(addUserButton))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, UserFrameLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(UserBackButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, UserFrameLayout.createSequentialGroup()
                                                .addComponent(userLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(searchButton)))
                                .addContainerGap())
        );
        UserFrameLayout.setVerticalGroup(
                UserFrameLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(UserFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(UserFrameLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton)
                                        .addComponent(userLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateUserButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addUserButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeUserButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(UserBackButton)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(UserFrame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(UserFrame, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        pack();

    }// </editor-fold>//GEN-END:initComponents

    private void updateUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserButtonActionPerformed
        try {
            int row = UserTable.getSelectedRow();
            if (row > -1) {
                if (UserTable.getModel().getValueAt(row, 0) != null) {
                    String queryID = UserTable.getModel().getValueAt(row, 0).toString();

                    try {
                        Statement stmt = myConn.createStatement();
                        String query = "select * from our_company.Users where User_ID=" + queryID;
                        ResultSet rs = stmt.executeQuery(query);
                        rs.next();

                        uFirstField.setText(rs.getString("first_name"));
                        uLastField.setText(rs.getString("last_name"));
                        uEmailField.setText(rs.getString("email_ID"));
                        uPasswordField.setText(rs.getString("password"));
                        uAccessField.setText(rs.getString("access"));
                    } catch (SQLException ex) {
                        System.out.println("Error string to update User");
                    }


                    newUser = false;

                    addUserFrame.setTitle("Update User");
                    addUserFrame.setVisible(true);
                } else {
                    errorMessage = "There's nothing to update!";
                    JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                errorMessage = "You must select a user first!";
                JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_updateUserButtonActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        //Reset all text fields/areas to null
        uFirstField.setText("");
        uLastField.setText("");
        uEmailField.setText("");
        uPasswordField.setText("");
        uAccessField.setText("");
        newUser = true;

        addUserFrame.setTitle("Add User");
        addUserFrame.setVisible(true);

    }//GEN-LAST:event_addUserButtonActionPerformed

    private void uCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uCancelButtonActionPerformed
        addUserFrame.setVisible(false);
    }//GEN-LAST:event_uCancelButtonActionPerformed

    private void uConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uConfirmButtonActionPerformed
        if(newUser)
            addUser();
        else
            updateUser();
        addUserFrame.setVisible(false);
    }//GEN-LAST:event_uConfirmButtonActionPerformed

    private void oBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oBackButtonActionPerformed
        this.dispose();
        ManagerGUI manager = new ManagerGUI();
    }//GEN-LAST:event_oBackButtonActionPerformed

    private void removeUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeUserButtonActionPerformed
        deleteUser();
    }//GEN-LAST:event_removeUserButtonActionPerformed


    //Adds an User into the database based on the info inputted in the addUserFrame
    public void addUser(){

        try {
            myConn = DriverManager.getConnection(database.url,database.user,database.password);
            if (myConn != null) {
                //System.out.println("Successfully connected to MySQL database test");
            }

            Statement stmt = myConn.createStatement();
            String query = "SELECT * FROM our_company.Users ORDER BY User_ID DESC LIMIT 1";
            ResultSet rs = stmt.executeQuery(query);
            int recentUserID;
            if (rs.next())
                recentUserID = rs.getInt("User_ID");
            else
                recentUserID = 0;

            //  ---INSERT STATEMENT---
            String sql = "insert into our_company.Users (User_ID, first_name, last_name, email_ID, password, last_login_date, access) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = myConn.prepareStatement(sql);

            statement.setInt(1, recentUserID+1);
            statement.setString(2, uFirstField.getText());
            statement.setString(3, uLastField.getText());
            statement.setString(4, uEmailField.getText());
            statement.setString(5, String.valueOf(uPasswordField.getPassword()));
            statement.setDate(6, Date.valueOf(java.time.LocalDate.now()));
            statement.setString(7, uAccessField.getText());

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("New user added successfully!");
            }

        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        updateUserTable();
    }


    //Updates the selected User on the database
    public void updateUser(){
        int row = UserTable.getSelectedRow();
        String queryID = UserTable.getModel().getValueAt(row, 0).toString();
        try {
            myConn = DriverManager.getConnection(database.url,database.user,database.password);

            Statement stmt = myConn.createStatement();
            String query = "SELECT * FROM our_company.Users where User_ID="+queryID;
            ResultSet rs = stmt.executeQuery(query);
            rs.next();

            int id = rs.getInt("user_ID");
            String first = uFirstField.getText();
            String last = uLastField.getText();
            String email = uEmailField.getText();
            String pw = String.valueOf(uPasswordField.getPassword());
            String access = uAccessField.getText();

            String sql = "update our_company.Users set "
                    + "first_name ='" + first + "',"
                    + "last_name ='" + last + "',"
                    + "email_id ='" + email + "',"
                    + "password='" + pw + "',"
                    + "last_login_date='" + java.time.LocalDate.now() + "',"
                    + "access='" + access + "'"
                    + " where User_ID=" + queryID;

            PreparedStatement p = myConn.prepareStatement(sql);
            p.execute();

        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

        updateUserTable();
        System.out.println("User successfully updated");
    }


    //Helps Update the GUI whenever the User table is changed
    //Notes: Maybe add some arguments for sorting later
    public void updateUserTable(){

        try {
            myConn = DriverManager.getConnection(database.url,database.user,database.password);
            PreparedStatement pst = myConn.prepareStatement("select * from our_company.Users");
            ResultSet rs = pst.executeQuery();
            int i = 0;

            DefaultTableModel table = new DefaultTableModel(new String [] {"User ID", "First Name", "Last Name", "Email", "Password", "Last Login Date", "Access"},0);

            while (rs.next()) {
                int id = rs.getInt("user_ID");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                String email = rs.getString("email_ID");
                String pass = rs.getString("password");
                Date login = rs.getDate("last_login_date");
                int access = rs.getInt("access");

                table.addRow(new Object[]{id, first, last, email, pass, login, access});
                UserTable.setModel(table);

            }

            if (!rs.next()) {
                table.addRow(new Object[]{null, null, null, null, null, null, null});
                UserTable.setModel(table);
            }

        }catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL database");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

    }


    //Deletes a User from the database
    //Note: GUI isn't updating when deleting the last User
    public void deleteUser(){
        try {
            int row = UserTable.getSelectedRow();

            if (row > -1) {

                try {
                    myConn = DriverManager.getConnection(database.url, database.user, database.password);

                    if (UserTable.getModel().getValueAt(row, 0) != null) {
                        String queryID = UserTable.getModel().getValueAt(row, 0).toString();
                        if (queryID.equals(LoginPage.user)) {
                            errorMessage = "You can't remove your own account!";
                            JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
                        } else {
                            String query = "delete from our_company.Users where User_ID=" + queryID;
                            PreparedStatement pst = myConn.prepareStatement(query);
                            pst.execute();
                            System.out.println("User successfully removed");
                        }
                    } else {
                        errorMessage = "There's nothing to remove!";
                        JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
                    }


                } catch (SQLException ex) {
                    System.out.println("An error occurred while connecting MySQL databse");
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }

                updateUserTable();
            } else {
                errorMessage = "You must select a user first!";
                JOptionPane.showMessageDialog(null, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    /**
     * @param args the command line arguments
     */




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserButton;
    private javax.swing.JFrame addUserFrame;

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton uCancelButton;
    private javax.swing.JButton uConfirmButton;
    private javax.swing.JButton UserBackButton;
    private javax.swing.JPanel UserFrame;
    private javax.swing.JTable UserTable;
    private javax.swing.JButton removeUserButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;

    private javax.swing.JButton updateUserButton;
    private javax.swing.JTextField uFirstField;
    private javax.swing.JTextField uLastField;
    private javax.swing.JTextField uEmailField;
    private javax.swing.JTextField uAccessField;
    private javax.swing.JPasswordField uPasswordField;
    private javax.swing.JLabel uFirstText;
    private javax.swing.JLabel uLastText;
    private javax.swing.JLabel uEmailText;
    private javax.swing.JLabel uAccessText;
    private javax.swing.JLabel uPasswordText;
    private javax.swing.JLabel userLabel;

    private static String errorMessage;

    // End of variables declaration//GEN-END:variables
}