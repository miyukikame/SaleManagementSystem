package database;

import java.sql.*;
import Classes.*;

public class ProductService {
    Connection myConn = DBConnection.connectDB();

    public ProductService(){
    }
    //füllt im Produkt Objekt den Array mit Produkten von der Datenbank auf
    public void fillArray(Products products) throws SQLException {
        Statement myStatement = myConn.createStatement();
        products.getProducts().clear();
        ResultSet myResult = myStatement.executeQuery("select * from products");
        // Process the result
        while(myResult.next()){
            products.getProducts().add(new Product(myResult.getString("product_name"),myResult.getString("product_description"),
                    myResult.getDouble("product_price"),myResult.getInt("product_stock")));
        }
    }
    //fügt der Datenbank ein neues Produkt hinzu
    public void addProductToDatabase(Product product) throws SQLException {
        //inserts a new product into the database
        String sql = "INSERT INTO products(product_name,product_description,product_price,product_stock)VALUES(?,?,?,?)";
        PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1,product.getName());
        statement.setString(2,product.getDescription());
        statement.setDouble(3,product.getPrice());
        statement.setInt(4,product.getStock());
        statement.executeUpdate();
        //todo refresh gui after adding new product
    }
}
