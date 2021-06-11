package database;
import java.sql.*;
import java.util.Date;

public class DBConnection {
    /**
     * tries to connect to the databse
     * @return the connector
     */
    public static Connection connectDB()
    {
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/pe_2021", "root", "");
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }


}
