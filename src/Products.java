import java.sql.*;
import java.util.ArrayList;

public class Products {
    private final Connection myConn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11410637", "sql11410637", "fQsr1VHqbJ");
    private final Statement myStatement = myConn.createStatement();
    private ResultSet myResult = null;
    private ArrayList<Product> products = new ArrayList<>();

    public Products() throws SQLException {
    }

    public void fillArray() throws SQLException {
        products.clear();
        // Execute SQL query
        myResult = myStatement.executeQuery("select * from products");
        // Process the result
        while(myResult.next()){
            products.add(new Product(myResult.getString("product_name"),myResult.getString("product_description"),
                                     myResult.getDouble("product_price"),myResult.getInt("product_stock")));
        }
    }

    public void addProductToDatabase(Product product) throws SQLException {
        //inserts a new product into the database
        String sql = "INSERT INTO products(product_name,product_description,product_price,product_stock)VALUES(?,?,?,?)";
        PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1,product.getName());
        statement.setString(2,product.getDescription());
        statement.setDouble(3,product.getPrice());
        statement.setInt(4,product.getStock());
        statement.executeUpdate();
        fillArray();
        //todo refresh gui after adding new product
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
