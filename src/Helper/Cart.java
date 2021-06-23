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
    public static float calculatePrice(ArrayList<JComboBox> quantities, ArrayList<Product> products){
        float tempPrice = 0;
        int i = 0;
        for (JComboBox quantity:
                quantities) {
            tempPrice += (float) (quantity.getSelectedIndex() * products.get(i).getPrice());
            i++;
        }
        return tempPrice;
    }
    public static void addProductToCart(Product product, int quantity){
        if(cartProducts.stream().anyMatch(f -> f.getName().equalsIgnoreCase(product.getName()))) {
            int tempIndex = cartProducts.indexOf(cartProducts.stream().filter(f -> f.getName().equalsIgnoreCase(product.getName())).findFirst().get());
            cartProductQuantity.set(tempIndex, cartProductQuantity.get(tempIndex) + quantity);
        }else{
            cartProducts.add(product);
            cartProductQuantity.add(quantity);
        }
    }
    public static void removeProductFromCart(int index){
        totalPrice -= (float) (cartProducts.get(index).getPrice() * cartProductQuantity.get(index));
        cartProducts.remove(index);
        cartProductQuantity.remove(index);
    }
}
