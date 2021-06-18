package Database;

import Classes.User;

import javax.swing.*;
import java.sql.*;

public class UserService {
    static Connection myConn = DBConnection.connectDB();

    public UserService(){

    }

    public static void register(User user) throws SQLException {
        String sql = "INSERT INTO USER(first_name,last_name,email,password)VALUES(?,?,?,?)";
        PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1,user.getFirstName());
        statement.setString(2,user.getLastName());
        statement.setString(3,user.getEmail());
        statement.setString(4,user.getPassword());
        statement.executeUpdate();
    }
    public static User login(String username, String password) throws SQLException{
        Statement myStatement = myConn.createStatement();
        ResultSet myResult = myStatement.executeQuery("SELECT * FROM USER WHERE email = \""+ username + "\" AND password = \"" + password + "\"");
        if(myResult.next()) {
            JOptionPane.showMessageDialog(null, "Welcome User");
            return new User(myResult.getInt("user_id"),
                    myResult.getString("first_name"),
                    myResult.getString("last_name"),
                    myResult.getString("email"),
                    password);
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Access denied", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }
}
