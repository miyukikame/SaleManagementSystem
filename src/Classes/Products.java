package Classes;

import database.ProductService;
import java.sql.*;
import java.util.ArrayList;


public class Products {

    ProductService productsDatabase = new ProductService();
    private final ArrayList<Product> products = new ArrayList<>();

    /**
     * fills the arraylist with product entities on object creation
     * @param productType - filter products
     * @throws SQLException -- throws exception when there is no connection to the server
     */
    public Products(String productType) throws SQLException {
        switch (productType) {
            case "Clothes"-> productsDatabase.fillArray(this, 1);
            case "Victuals" -> productsDatabase.fillArray(this, 2);
            case "Technology" -> productsDatabase.fillArray(this, 3);
        }
    }
    //fügt ein Produkt der Datenbank hinzu und aktualisiert die ArrayList mit dem neuen Produkt

    /**
     * creates a new entity in the product table
     * @param product - product object
     * @throws SQLException -- throws exception when there is no connection to the server
     */
    public void addProduct(Product product) throws SQLException {
        productsDatabase.addProductToDatabase(product);
        productsDatabase.fillArray(this, product.getType());
    }

    /**
     * returns Arraylist with Product objects
     * @return
     */
    public ArrayList<Product> getProducts() {
        return products;
    }
}
