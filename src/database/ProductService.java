package database;

import java.sql.*;
import Classes.*;

public class ProductService {
    Connection myConn = DBConnection.connectDB();

    public ProductService(){
    }
    //füllt im Produkt Objekt den Array mit Produkten von der Datenbank auf
    public void fillArray(Products products, int type) throws SQLException {
        Statement myStatement = myConn.createStatement();
        products.getProducts().clear();
        ResultSet myResult = myStatement.executeQuery("select * from PRODUCTS WHERE Type = " + type);
        // Process the result
        while(myResult.next()){
            products.getProducts().add(new Product(myResult.getString("Name"),myResult.getString("Description"),
                    myResult.getDouble("Price"),myResult.getInt("Quantity")));
        }
    }
    //fügt der Datenbank ein neues Produkt hinzu
    public void addProductToDatabase(Product product) throws SQLException {
        //inserts a new product into the database
        String sql = "INSERT INTO PRODUCTS(Name,Description,Price,Quantity,Type)VALUES(?,?,?,?,?)";
        PreparedStatement statement = myConn.prepareStatement(sql);
        statement.setString(1,product.getName());
        statement.setString(2,product.getDescription());
        statement.setDouble(3,product.getPrice());
        statement.setInt(4,product.getStock());
        statement.setInt(5,product.getType());
        statement.executeUpdate();
        //todo refresh gui after adding new product
    }
}
