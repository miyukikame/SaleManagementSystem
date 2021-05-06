import java.sql.*;

class Main {
    public static void main(String[] args) {
        try {
           /* //Get a connection to the database
            //Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "sdasdasda");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11410637", "sql11410637", "fQsr1VHqbJ");
            // Create a statement
            Statement myStatement = myConn.createStatement();
            // Execute SQL query
            ResultSet myResult = myStatement.executeQuery("select * from employees");
            // Process the result
            while(myResult.next()){
                System.out.println(myResult.getString("last_name") + "  " + myResult.getString("first_name"));
            }*/
            Products testing = new Products();
            testing.fillArray();
            System.out.println(testing.getProducts().get(1).getPriceFormatted());
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}