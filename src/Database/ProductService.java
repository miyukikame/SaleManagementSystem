package Database;

import java.sql.*;
import java.util.ArrayList;

import Classes.*;

public class ProductService {
    private final Connection myConn = DBConnection.connectDB();
    private ArrayList<Product> products = new ArrayList<>();

    public ProductService(String productType) throws SQLException {
        switch (productType) {
            case "Clothes"-> this.fillArray(products, 1);
            case "Victuals" -> this.fillArray(products, 2);
            case "Technology" -> this.fillArray(products, 3);
        }
    }
    /**
     * fills the arraylist with product entities
     * @param products - products object
     * @param product_type - filter products
     * @throws SQLException -- throws exception when there is no connection to the server
     */
    public void fillArray(ArrayList<Product> products, int product_type) throws SQLException {
        assert myConn != null;
        Statement myStatement = myConn.createStatement();
        products.clear();
        ResultSet myResult = myStatement.executeQuery("select * from PRODUCT WHERE category_id = " + product_type);
        // Process the result
        while(myResult.next()){
            products.add(new Product(myResult.getString("Name"),myResult.getDouble("Price"),myResult.getInt("Quantity"), myResult.getInt("category_id")));
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
