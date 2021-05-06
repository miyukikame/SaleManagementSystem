package database;
import java.sql.*;

public class DBConnection {
    private static Connection conn = null;

    public static Connection connectDB()
    {
        try{
            conn=DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11410637", "sql11410637", "fQsr1VHqbJ");
            return conn;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

}
