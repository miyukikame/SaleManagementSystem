package Classes;

import database.ProductService;
import java.sql.*;
import java.util.ArrayList;

public class Products {
    ProductService productsDatabase = new ProductService();
    private final ArrayList<Product> products = new ArrayList<>();

    //füllt beim erstellen eines Objekt automatisch die Arraylist auf
    public Products(String type) throws SQLException {
        switch (type) {
            case "Clothes"-> productsDatabase.fillArray(this, 1);
            case "Victuals" -> productsDatabase.fillArray(this, 2);
            case "Technology" -> productsDatabase.fillArray(this, 3);
        }
    }
    //fügt ein Produkt der Datenbank hinzu und aktualisiert die ArrayList mit dem neuen Produkt
    public void addProduct(Product product) throws SQLException {
        productsDatabase.addProductToDatabase(product);
        productsDatabase.fillArray(this, product.getType());
    }

    //returns Arraylist with Product objects
    public ArrayList<Product> getProducts() {
        return products;
    }
}
