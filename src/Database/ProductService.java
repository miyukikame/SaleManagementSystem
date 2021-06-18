package Database;

import java.sql.*;
import Classes.*;

public class ProductService {
    Connection myConn = DBConnection.connectDB();

    public ProductService(){
    }
    /**
     * fills the arraylist with product entities
     * @param products - products object
     * @param product_type - filter products
     * @throws SQLException -- throws exception when there is no connection to the server
     */
    public void fillArray(Products products, int product_type) throws SQLException {
        Statement myStatement = myConn.createStatement();
        products.getProducts().clear();
        ResultSet myResult = myStatement.executeQuery("select * from PRODUCT WHERE category_id = " + product_type);
        // Process the result
        while(myResult.next()){
            products.getProducts().add(new Product(myResult.getString("Name"),myResult.getDouble("Price"),myResult.getInt("Quantity"), myResult.getInt("category_id")));
        }
    }
    /**
     * creates a new entity in the product table
     * @param product - product object
     * @throws SQLException -- throws exception when there is no connection to the server
     */
    public void addProductToDatabase(Product product) throws SQLException {
        //inserts a new product into the database
        String sql = "INSERT INTO PRODUCT(Name,Price,Quantity,Type)VALUES(?,?,?,?)";
        PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1,product.getName());
        statement.setDouble(2,product.getPrice());
        statement.setInt(3,product.getStock());
        statement.setInt(4,product.getType());
        statement.executeUpdate();
    }
}
