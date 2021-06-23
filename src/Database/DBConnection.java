package Database;
import java.sql.*;

public class DBConnection {
    /**
     * tries to connect to the databse
     * @return the connector
     */
    public static Connection connectDB()
    {
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/pe_2023", "root", "");
        }
        catch(SQLException ex){
            System.out.println("Es konnte keine Verbindung zum Datenbank Server aufgebaut werden.");
            return null;
        }
    }

}
