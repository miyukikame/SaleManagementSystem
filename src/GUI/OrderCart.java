package GUI;

import Classes.Product;
import Database.UserService;
import Helper.Cart;
import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderCart extends javax.swing.JFrame{
    /**
     *
     *
     */
    public OrderCart(){
        //region variable declaration
        ArrayList<JLabel> itemName = new ArrayList<>();
        ArrayList<JLabel> itemPrice = new ArrayList<>();
        ArrayList<JLabel> itemQuantity = new ArrayList<>();
        ArrayList<JButton> removeProduct = new ArrayList<>();
        JLabel itemSection = new JLabel("Cart");
        JLabel productName = new JLabel("Name");
        JLabel productPrice = new JLabel("Price");
        JLabel productQuantity = new JLabel("Quantity");
        JLabel cartTotalPriceText = new JLabel("Total Price");
        JTextField cartTotalPrice = new JTextField();
        JButton mainPage = new JButton("Mainpage");
        JButton cart = new JButton("Order");
        itemSection.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainPage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cartTotalPriceText.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mainPage.addActionListener(actionEvent -> {
            dispose();
            Mainpage test = new Mainpage();
            test.setLocationRelativeTo(null);
        });
        cart.addActionListener(actionEvent -> {
            if(Cart.totalPrice == 0){
                JOptionPane.showMessageDialog(null, "You don't have any products in your cart");
            }else {
                try {
                    if(UserService.hasInfo(Cart.user.getId())){
                        OrderConfirmation orderConfirmation = new OrderConfirmation();
                        orderConfirmation.setVisible(true);
                        orderConfirmation.setLocationRelativeTo(null);
                    }
                    else{
                        ShippingAddress shippingAddress = new ShippingAddress();
                        shippingAddress.setVisible(true);
                        shippingAddress.setLocationRelativeTo(null);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        cartTotalPrice.setEditable(false);
        cartTotalPrice.setText(Cart.totalPrice + "$");
        if(Cart.cartProducts!=null) {
            for (Product test :
                    Cart.cartProducts) {
                removeProduct.add(new JButton("x"));
                itemName.add(new JLabel(test.getName()));
                itemPrice.add(new JLabel(test.getPriceFormatted()));
            }
            for (int quantityInt :
                    Cart.cartProductQuantity) {
                JLabel quantity = new JLabel();
                quantity.setText(String.valueOf(quantityInt));
                itemQuantity.add(quantity);
            }
        }
        //endregion
        for (int i = 0; i < removeProduct.size(); i++) {
            int finalI = i;
            removeProduct.get(i).addActionListener(actionEvent -> {
                Cart.removeProductFromCart(finalI);
                dispose();
                new OrderCart();
            });
        }
        getContentPane().setBackground(new java.awt.Color(231, 246, 255));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GroupLayout.ParallelGroup itemCollection = groupLayout.createParallelGroup();
        itemCollection.addComponent(productName);
        for (JLabel test :
                itemName) {
            itemCollection.addComponent(test);

        }
        GroupLayout.ParallelGroup priceCollection = groupLayout.createParallelGroup();
        priceCollection.addComponent(productPrice);
        for (JLabel test :
                itemPrice) {
            priceCollection.addComponent(test);

        }
        GroupLayout.ParallelGroup quantityCollection = groupLayout.createParallelGroup();
        quantityCollection.addComponent(productQuantity);
        for (JLabel test :
                itemQuantity) {
            quantityCollection.addComponent(test);

        }
        GroupLayout.ParallelGroup removeButtonCollection = groupLayout.createParallelGroup();
        for (JButton test :
                removeProduct) {
            removeButtonCollection.addComponent(test);
        }

        GroupLayout.SequentialGroup verticalGroup = groupLayout.createSequentialGroup();
        verticalGroup.addComponent(itemSection);
        verticalGroup.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(productName)
                .addComponent(productPrice)
                .addComponent(productQuantity));
        for (int i = 0; i < itemPrice.size(); i++) {
            verticalGroup.addGroup(groupLayout.createParallelGroup()
                    .addComponent(itemName.get(i))
                    .addComponent(itemPrice.get(i))
                    .addComponent(itemQuantity.get(i))
                    .addComponent(removeProduct.get(i)));
        }
        verticalGroup.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cartTotalPriceText)
                .addComponent(cartTotalPrice));
        verticalGroup.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(mainPage)
                .addComponent(cart));

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(itemCollection.addComponent(mainPage))
                        .addComponent(itemSection)
                        .addGroup(priceCollection)
                        .addGroup(quantityCollection
                                .addComponent(cartTotalPriceText))
                        .addGroup(removeButtonCollection
                                .addComponent(cartTotalPrice)
                                .addComponent(cart))
        );
        groupLayout.setVerticalGroup(
                verticalGroup
        );
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    /**
     * Creates new form Clothes
     */
    public static void main(String[] args){
    }

    /**
     *
     */
    @Override
    public void dispose() {
        System.out.println("Your total price is: " + Cart.totalPrice);
        super.dispose();
    }





}
