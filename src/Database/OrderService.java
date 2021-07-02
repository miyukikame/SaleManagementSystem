package Database;

import Classes.Product;
import Helper.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import GUI.ShippingAddress;

import javax.swing.*;


public class OrderService {
    private final static Connection myConn = DBConnection.connectDB();
    //INESRT ito ORDERS table attributes : user_id,order_date,total_price.
   static public void InsertOrder() {
        String sql = "INSERT INTO ORDERS(user_id,order_date,total_price)VALUES(?,?,?)";
        try {
            PreparedStatement  statement = myConn.prepareStatement(sql);
            statement.setInt(1, Cart.user.getId());
            statement.setString(2, String.valueOf(LocalDate.now()));
            statement.setString(3,String.valueOf(Cart.totalPrice)+"$");
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Fehlernmeldung bei OrderCart Button order :"+e);
        }
    }
    //UPDATE product table attributes : quantity
    static public void UpdateQuantity() {
        int i = 0;
        for(Product test:
                Cart.cartProducts){
            try {
                System.out.println(test.getStock());
                System.out.println(Cart.cartProductQuantity.get(i));
                String sql = "update product set quantity = ? where product_id = ?";
                PreparedStatement statement = myConn.prepareStatement(sql);
                statement.setInt(1, test.getStock() - Cart.cartProductQuantity.get(i));
                statement.setInt(2, test.getId());
                statement.executeUpdate();
                test.setStock(test.getStock() - Cart.cartProductQuantity.get(i));
                i++;
            } catch (SQLException e) {
                System.out.println("Fehler"+e);
            }
        }
    }

    }

