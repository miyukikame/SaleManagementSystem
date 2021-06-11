package GUI.Helper;


import GUI.Mainpage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class FrameGen extends javax.swing.JFrame{
    /**
     *
     * @throws SQLException
     */
    public FrameGen() throws SQLException {
        //region variable declaration
        Classes.Products products;
        ArrayList<JLabel> itemName = new ArrayList<>();
        ArrayList<JLabel> itemPrice = new ArrayList<>();
        ArrayList<JComboBox> itemQuantity = new ArrayList<>();
        JLabel itemSection = new JLabel(getClass().getSimpleName());
        JButton mainPage = new JButton("Mainpage");
        final double tempPrice = 0;
        JButton cart = new JButton("Go to Cart");
        itemSection.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        mainPage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mainPage.addActionListener(actionEvent -> {
            dispose();
            Mainpage test = new Mainpage();
            test.setLocationRelativeTo(null);
        });

        products = new Classes.Products(getClass().getSimpleName());
        for (int i = 0; i < products.getProducts().size(); i ++) {
            itemName.add(new JLabel());
            itemName.get(i).setFont(new java.awt.Font("Tahoma", 1, 14));
            itemName.get(i).setText(products.getProducts().get(i).getName());
            itemPrice.add(new JLabel());
            itemPrice.get(i).setFont(new java.awt.Font("Tahoma", 1, 14));
            itemPrice.get(i).setText(products.getProducts().get(i).getPriceFormatted());
            itemQuantity.add(new JComboBox());
            itemQuantity.get(i).setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
            int finalI = i;
            itemQuantity.get(i).addItemListener(itemEvent -> {
                if(itemEvent.getStateChange() == ItemEvent.SELECTED){
                    Cart.currentPrice = Cart.calculatePrice(itemQuantity, products);
                    System.out.println("The current price is: " + Cart.currentPrice);
                }
            });
        }
        //endregion

        //JPanel frame = new JPanel();
        getContentPane().setBackground(Color.GREEN);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GroupLayout.ParallelGroup itemCollection = groupLayout.createParallelGroup();
        for (JLabel test :
                itemName) {
            itemCollection.addComponent(test);

        }
        GroupLayout.ParallelGroup priceCollection = groupLayout.createParallelGroup();
        for (JLabel test :
                itemPrice) {
            priceCollection.addComponent(test);

        }
        GroupLayout.ParallelGroup quantityCollection = groupLayout.createParallelGroup();
        for (JComboBox test :
                itemQuantity) {
            quantityCollection.addComponent(test);

        }

        GroupLayout.SequentialGroup verticalGroup = groupLayout.createSequentialGroup();
        verticalGroup.addComponent(itemSection);
        for (int i = 0; i < itemPrice.size(); i++) {
            verticalGroup.addGroup(groupLayout.createParallelGroup()
                    .addComponent(itemName.get(i))
                    .addComponent(itemPrice.get(i))
                    .addComponent(itemQuantity.get(i)));
        }
        verticalGroup.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(mainPage)
                .addComponent(cart));

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(itemCollection.addComponent(mainPage))
                        .addComponent(itemSection)
                        .addGroup(priceCollection)
                        .addGroup(quantityCollection
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
    public static void main(String[] args) throws SQLException {
    }

    /**
     *
     */
    @Override
    public void dispose() {
        Cart.totalPrice += Cart.currentPrice;
        System.out.println("Your total price is: " + Cart.totalPrice);
        System.out.println("Your current price is: " + Cart.currentPrice);
        super.dispose();
    }




}