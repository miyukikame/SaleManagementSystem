package Helper;

import Classes.Product;

import javax.swing.*;
import java.util.ArrayList;

public final class Cart {
    public static ArrayList<Product> cartProducts = new ArrayList<>();
    public static ArrayList<Integer> cartProductQuantity = new ArrayList<>();
    public static float currentPrice = 0;
    public static float totalPrice = 0;

    /**
     *
     * @param quantities - get prices of all filtered products
     * @param products - objects of all filtered products
     * @return the calculated temporary price
     */
    public static double calculatePrice(ArrayList<JComboBox> quantities, Classes.Products products){
        float tempPrice = 0;
        int i = 0;
        for (JComboBox quantity:
                quantities) {
            tempPrice += quantity.getSelectedIndex() * products.getProducts().get(i).getPrice();
            i++;
        }
        return tempPrice;
    }
    public static void addProductToCart(Product product, int quantity){
        cartProducts.add(product);
        cartProductQuantity.add(quantity);
    }
    public static void removeProductFromCart(int index){
        totalPrice = (float) (totalPrice - (float) (cartProducts.get(index).getPrice() * cartProductQuantity.get(index)));
        cartProducts.remove(index);
        cartProductQuantity.remove(index);
    }
}
