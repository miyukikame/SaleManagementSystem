package GUI.Helper;

import javax.swing.*;
import java.util.ArrayList;

public final class Cart {
    public static double currentPrice = 0;
    public static double totalPrice = 0;

    /**
     *
     * @param quantities - get prices of all filtered products
     * @param products - objects of all filtered products
     * @return the calculated temporary price
     */
    public static double calculatePrice(ArrayList<JComboBox> quantities, Classes.Products products){
        double tempPrice = 0;
        int i = 0;
        for (JComboBox quantity:
                quantities) {
            tempPrice += quantity.getSelectedIndex() * products.getProducts().get(i).getPrice();
            i++;
        }
        return tempPrice;
    }
}
