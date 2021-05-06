package Classes;

import database.ProductService;
import java.sql.*;
import java.util.ArrayList;

public class Products {
    ProductService productsDatabase = new ProductService();
    private ArrayList<Product> products = new ArrayList<>();

    //füllt beim erstellen eines Objekt automatisch die Arraylist auf
    public Products() throws SQLException {
        productsDatabase.fillArray(this);
    }
    //fügt ein Produkt der Datenbank hinzu und aktualisiert die ArrayList mit dem neuen Produkt
    public void addProduct(Product product) throws SQLException {
        productsDatabase.addProductToDatabase(product);
        productsDatabase.fillArray(this);
    }

    //returns Arraylist with Product objects
    public ArrayList<Product> getProducts() {
        return products;
    }
}
